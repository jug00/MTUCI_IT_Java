package Lab4;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FractalExplorer {

    private int rowsRemaining;
    private final int displaySize;
    private final JImageDisplay jImageDisplay;
    private FractalGenerator fractal;
    private final Rectangle2D.Double range;

    public FractalExplorer(int displaySize){
        this.displaySize = displaySize;
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        jImageDisplay = new JImageDisplay(displaySize, displaySize);
    }

    JButton resetButton = new JButton("Reset");
    JButton saveButton = new JButton("Save Image");
    JComboBox jComboBoxFractals = new JComboBox();
    public void createAndShowGUI(){
        jImageDisplay.setLayout(new BorderLayout());
        JFrame jFrame = new JFrame("Fractal Explorer");
        jFrame.add(jImageDisplay, BorderLayout.CENTER);

        JPanel jPanelSouth = new JPanel();
        JPanel jPanelNorth = new JPanel();

        jPanelSouth.add(resetButton);

        jPanelSouth.add(saveButton);

        JLabel jLabelFractal = new JLabel("Fractal:");
        jPanelNorth.add(jLabelFractal);

        jComboBoxFractals.addItem(new Mandelbrot());
        jComboBoxFractals.addItem(new Tricorn());
        jComboBoxFractals.addItem(new BurningShip());
        jPanelNorth.add(jComboBoxFractals);

        jFrame.add(jPanelSouth, BorderLayout.SOUTH);
        jFrame.add(jPanelNorth, BorderLayout.NORTH);

        ButtonHandler buttonHandler = new ButtonHandler();
        MouseHandler click = new MouseHandler();

        saveButton.addActionListener(buttonHandler);
        jComboBoxFractals.addActionListener(buttonHandler);
        resetButton.addActionListener(buttonHandler);
        jImageDisplay.addMouseListener(click);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack ();
        jFrame.setVisible (true);
        jFrame.setResizable (false);

    }

    private void drawFractal(){
        enableUI(false);
        rowsRemaining = jImageDisplay.getHeight();
        for (int y = 0; y < jImageDisplay.getHeight(); y++) {
            FractalWorker line = new FractalWorker(y);
            line.execute();
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String action  = e.getActionCommand();
            if (action.equals("Reset")) {
                fractal.getInitialRange(range);
                drawFractal();
            } else if (action.equals("comboBoxChanged")) {
                JComboBox source = (JComboBox) e.getSource();
                fractal = (FractalGenerator) source.getSelectedItem();
                fractal.getInitialRange(range);
                drawFractal();
            } else if (action.equals("Save Image")) {
                JFileChooser chooser = new JFileChooser();
                FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
                chooser.setFileFilter(filter);
                chooser.setAcceptAllFileFilterUsed(false);
                int result = chooser.showSaveDialog(jImageDisplay);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    BufferedImage image = jImageDisplay.getBufferedImage();
                    try {
                        ImageIO.write(image, "png", file);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(jImageDisplay,
                                ex.getMessage(), "Cannot Save Image",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        }

    private class MouseHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e){
            if (rowsRemaining == 0) {
                int x = e.getX();
                int y = e.getY();
                double xCoord = FractalGenerator.getCoord(range.x,
                        range.x + range.width, displaySize, x);
                double yCoord = FractalGenerator.getCoord(range.y,
                        range.y + range.height, displaySize, y);
                fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
                drawFractal();
            }
        }
    }

    void enableUI(boolean val){
        resetButton.setEnabled(val);
        saveButton.setEnabled(val);
        jComboBoxFractals.setEnabled(val);
    }

    public static void main(String[] args)
    {
        FractalExplorer fractalExplorer = new FractalExplorer(700);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.drawFractal();
    }

    private class FractalWorker extends SwingWorker<Object, Object>{

        int yCoord;
        int[] rgbs;

        public FractalWorker(int yCoord){
            this.yCoord = yCoord;
        }
        @Override
        protected Object doInBackground() throws Exception {
            rgbs = new int[jImageDisplay.getWidth()];
            for (int x = 0; x < jImageDisplay.getWidth(); x++) {
                double xCoord = FractalGenerator.getCoord (range.x, range.x + range.width,
                        displaySize, x);
                double yCoord = FractalGenerator.getCoord (range.y, range.y + range.width,
                        displaySize, this.yCoord);
                int numIterations = fractal.numIterations(xCoord, yCoord);
                if (numIterations == -1) {
                    rgbs[x] = 0;
                } else {
                    float hue = 0.723f + (float)numIterations/200f;
                    rgbs[x] = Color.HSBtoRGB(hue, 1f, 1f);
                }
            }
            return null;
    }

        @Override
        protected void done() {
            for (int x = 0; x < jImageDisplay.getWidth(); x++) {
                jImageDisplay.drawPixel(x, this.yCoord, rgbs[x]);
            }
            jImageDisplay.repaint(0,0, yCoord, displaySize,1);
            rowsRemaining--;
            if (rowsRemaining == 0) {
                enableUI(true);
            }
        }
        }
    }

