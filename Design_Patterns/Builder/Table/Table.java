/**
 * In this example we render a tabular data read from a file
 * into a GUI table. The requirement of this job is to be
 * able to pick a different GUI implementation in run time.
 *
 * This is the code AFTER we applied the Builder pattern.
 *
 * Note: for the sake of simplicity of comparison
 * between BEFORE and AFTER, we have made all important
 * classes internal, so that they can live together in
 * one file. This is not a pattern limitation.
 */

package com.sourcemaking.builder.table_builder.after;
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
        String class_name = args.length > 0 ? args[0] : "JTable_Builder";

        Builder target = null;
        try {
            target = (Builder) Class.forName(getClass().getName() + "$" + class_name)
                    .getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String file_name = getClass().getResource("../BuilderDemo.dat").getFile();
        TableDirector director = new TableDirector(target);
        director.construct(file_name);
        Component comp = target.get_result();

        JFrame frame = new JFrame("BuilderDemo - " + class_name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(comp);
        frame.pack();
        frame.setVisible(true);
    }

    interface Builder {
        void set_width_and_height(int width, int height);

        void start_row();

        void build_cell(String value);

        Component get_result();
    }

    public static class JTable_Builder implements Builder {
        private JTable m_table;
        private TableModel m_model;
        private int x = 0, y = 0;

        public void set_width_and_height(int width, int height) {
            m_table = new JTable(height, width);
            m_model = m_table.getModel();
        }

        public void start_row() {
            x = 0;
            ++y;
        }

        public void build_cell(String value) {
            m_model.setValueAt(value, y, x++);
        }

        public Component get_result() {
            return m_table;
        }
    }

    public static class GridLayout_Builder implements Builder {
        private JPanel m_panel = new JPanel();

        public void set_width_and_height(int width, int height) {
            m_panel.setLayout(new GridLayout(height, width));
            m_panel.setBackground(Color.white);
        }

        public void start_row() {
        }

        public void build_cell(String value) {
            m_panel.add(new Label(value));
        }

        public Component get_result() {
            return m_panel;
        }
    }

    public static class GridBagLayout_Builder implements Builder {
        private JPanel m_panel = new JPanel();
        private GridBagConstraints c = new GridBagConstraints();
        private int x = 0, y = 0;

        public void set_width_and_height(int width, int height) {
            m_panel.setLayout(new GridBagLayout());
            m_panel.setBackground(Color.white);
        }

        public void start_row() {
            x = 0;
            ++y;
        }

        public void build_cell(String value) {
            c.gridx = x++;
            c.gridy = y;
            m_panel.add(new Label(value), c);
        }

        public Component get_result() {
            return m_panel;
        }
    }

    class TableDirector {
        private Builder m_builder;

        public TableDirector(Builder b) {
            m_builder = b;
        }

        public void construct(String file_name) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file_name));
                String line;
                String[] cells;

                if ((line = br.readLine()) != null) {
                    cells = line.split("\\t");
                    int width = Integer.parseInt(cells[0]);
                    int height = Integer.parseInt(cells[1]);
                    m_builder.set_width_and_height(width, height);
                }

                while ((line = br.readLine()) != null) {
                    cells = line.split("\\t");
                    for (int col = 0; col < cells.length; ++col) {
                        m_builder.build_cell(cells[col]);
                    }
                    m_builder.start_row();
                }

                br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}