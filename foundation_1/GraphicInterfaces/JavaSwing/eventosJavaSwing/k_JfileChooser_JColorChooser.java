package GraphicInterfaces.JavaSwing.eventosJavaSwing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 @JColorChooser -> Es un componente que proporciona una interfaz de usuario para seleccionar colores. ->puede agregarse a cualquier
                  contenedor -> se usa a menudo en un diálogo emergente -> El método statico showDialog muestra el dialogo de slección de
                  color. -> devuelve una instancia de Color o null.

 @JFileChooser -> Proporciona una ventana para navegar por el sistema de archivos y seleccionar uno. -> showOpenDialog muestra el dialogo
                  de apertira y showSaveDialog uno de guardado de archivo. -> Los dialogos son modal
 */
public class k_JfileChooser_JColorChooser {
    public static void main(String[] args) {
        //new exampleChooseColor();

        // Esta forma se usa porque jSwing trabaja sobre un unico hilo, para no bloquearlo se usa así (Concepto EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new exampleFlieChooser();
            }
        });
        // alternativa más corta
       // SwingUtilities.invokeLater(() -> new exampleFlieChooser());
    }

    // creando una calse que extiende de JFrame para saltar algunos metodos
    public static class exampleChooseColor extends JFrame {
        private Color circleColor = Color.BLACK;
        private int diameter = 200;

        public exampleChooseColor() {
            setSize(400, 400);
            setLocationRelativeTo(null);

            //boton para abrir el colorChooser
            JButton button = new JButton("Choose Color");
            button.setFocusable(false);
            button.addActionListener(e -> {
                Color colorSelected = JColorChooser.showDialog(null, "Choose circle color", circleColor);
                //elejimos color y repintamos
                if (colorSelected != null) {
                    circleColor = colorSelected;
                    repaint();// al pintar directamente sobre un componente no se necesita el repaint (no recomendado)
                }
            });

            //agregando boton y layout
            add(button, BorderLayout.SOUTH);

            //Visibilidad y cierre
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            int y = (getHeight() - diameter) / 2;
            int x = (getWidth() - diameter) / 2;

            g.setColor(circleColor);
            g.fillOval(x, y, diameter, diameter);
        }
    }

    public static class exampleFlieChooser extends JFrame {
        private JLabel tagImage;
        private BufferedImage image;

        public exampleFlieChooser(){
            //configuramos el JFrame
            setTitle("Example FileChoser");
            setSize(500, 500);
            setLayout(new BorderLayout());

            //añadimos el JLabel al centro
            tagImage = new JLabel();
            add(tagImage, BorderLayout.CENTER);

            //añadimos boton en la parte inferior
            JButton button = new JButton("Choose Image");
            add(button, BorderLayout.SOUTH);

            //evento pulsar el boton
            button.addActionListener(e -> {
                JFileChooser chooser = new JFileChooser();
                int option = chooser.showOpenDialog(this);
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = chooser.getSelectedFile();
                    uploadImage(file);
                }
            });

            //visibilidad y cierre
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);

        }

        private void uploadImage (File file){
            try {
                image = ImageIO.read(file);
                tagImage.setIcon(new ImageIcon(scaleImage (image)));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error to charge image", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private Image scaleImage (BufferedImage originalImage){
            double originalProportion = (double) originalImage.getWidth() / (double) originalImage.getHeight();
            int width = getWidth();
            int height = (int) (getHeight() * originalProportion);

            return originalImage.getScaledInstance(height, width, Image.SCALE_SMOOTH);

        }
    }
}