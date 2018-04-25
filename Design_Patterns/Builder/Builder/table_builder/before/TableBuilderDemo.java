/**
 * In this example we render a tabular data read from a file
 * into a GUI table. The requirement of this job is to be
 * able to pick a different GUI implementation in run time.
 *
 * This is the code BEFORE we applied the Builder pattern.
 *
 * Note: for the sake of simplicity of comparison
 * between BEFORE and AFTER, we have made all important
 * classes internal, so that they can live together in
 * one file. This is not a pattern limitation.
 */

package com.sourcemaking.builder.table_builder.before;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class TableBuilderDemo {

    public static void main(String[] args) {
        (new TableBuilderDemo()).demo(args);
    }

    /**
     * Client code perspective.
     */
    public void demo(String[] args) {
        // Name of the GUI table class can be passed to the app parameters.
        String class_name = args.length > 0 ?  args[0] : "JTable_Table";

        // Then we read the tabular data from file...
        String file_name = getClass().getResource("../BuilderDemo.dat").getFile();
        String[][] matrix = read_data_file(file_name);

        // ..and pass it to specific GUI creator, which knows what GUI
        // component to create and how to initialize it.
        Component comp;
        if (class_name.equals("GridLayout_Table")) {
            comp = new GridLayout_Table(matrix).get_table();
        } else if (class_name.equals("GridBagLayout_Table")) {
            comp = new GridBagLayout_Table(matrix).get_table();
        } else {
            comp = new JTable_Table(matrix).get_table();
        }

        // Finally, create a GUI window and put there our table component.
        JFrame frame = new JFrame("BuilderDemo - " + class_name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(comp);
        frame.pack();
        frame.setVisible(true);
    }

    class JTable_Table {
        private JTable m_table;

        public JTable_Table(String[][] matrix) {
            m_table = new JTable(matrix[0].length, matrix.length);

            TableModel model = m_table.getModel();
            for (int i = 0; i < matrix.length; ++i)
                for (int j = 0; j < matrix[i].length; ++j)
                    model.setValueAt(matrix[i][j], j, i);
        }

        public Component get_table() {
            return m_table;
        }
    }

    class GridLayout_Table {
        private JPanel m_table = new JPanel();

        public GridLayout_Table(String[][] matrix) {
            m_table = new JPanel();
            m_table.setLayout(new GridLayout(matrix[0].length, matrix.length));
            m_table.setBackground(Color.white);

            for (int i = 0; i < matrix[i].length; ++i)
                for (int j = 0; j < matrix.length; ++j)
                    m_table.add(new Label(matrix[j][i]));
        }

        public Component get_table() {
            return m_table;
        }
    }

    class GridBagLayout_Table {
        private JPanel m_table = new JPanel();

        public GridBagLayout_Table(String[][] matrix) {
            GridBagConstraints c = new GridBagConstraints();

            m_table.setLayout(new GridBagLayout());
            m_table.setBackground(Color.white);

            for (int i = 0; i < matrix.length; ++i)
                for (int j = 0; j < matrix[i].length; ++j) {
                    c.gridx = i;
                    c.gridy = j;
                    m_table.add(new Label(matrix[i][j]), c);
                }
        }

        public Component get_table() {
            return m_table;
        }
    }

    public static String[][] read_data_file(String file_name) {
        String[][] matrix = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file_name));
            String line;
            String[] cells;

            if ((line = br.readLine()) != null) {
                cells = line.split("\\t");
                int width = Integer.parseInt(cells[0]);
                int height = Integer.parseInt(cells[1]);
                matrix = new String[width][height];
            }

            int row = 0;
            while ((line = br.readLine()) != null) {
                cells = line.split("\\t");
                for (int i = 0; i < cells.length; ++i) {
                    matrix[i][row] = cells[i];
                }
                row++;
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return matrix;
    }
}