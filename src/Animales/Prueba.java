package Animales;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prueba {
    private static JTextArea textArea;

    public static void main(String[] args) {
        Animal[] animales = new Animal[4];
        animales[0] = new Gato();
        animales[1] = new Perro();
        animales[2] = new Lobo();
        animales[3] = new León();

        JFrame frame = new JFrame("Prueba de Animales");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JComboBox<String> comboBox = new JComboBox<>();
        for (Animal animal : animales) {
            comboBox.addItem(animal.getClass().getSimpleName());
        }
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String animalSeleccionado = (String) comboBox.getSelectedItem();
                for (Animal animal : animales) {
                    if (animal.getClass().getSimpleName().equals(animalSeleccionado)) {
                        mostrarInformacion(animal);
                        break;
                    }
                }
            }
        });

        panel.add(comboBox);

        textArea = new JTextArea(10, 30);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void mostrarInformacion(Animal animal) {
        textArea.setText("");
        textArea.append("Nombre científico: " + animal.getNombreCientífico() + "\n");
        textArea.append("Sonido: " + animal.getSonido() + "\n");
        textArea.append("Alimentos: " + animal.getAlimentos() + "\n");
        textArea.append("Hábitat: " + animal.getHábitat() + "\n");
    }
}
