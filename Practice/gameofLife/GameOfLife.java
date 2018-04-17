package design.practice.gameofLife;


import java.awt.*;
import java.awt.event.*;
import java.util.Hashtable;
import javax.swing.*;


/*The universe of the gameofLife is an infinite two-dimensional orthogonal grid of square cells,
each of which is in one of two possible states, live or dead. 
Every cell interacts with its eight neighbors, which are the cells that are directly horizontally, 
vertically, or diagonally adjacent. At each step in time, the following transitions occur:

1.Any live cell with fewer than two alive neighbours dies, as if caused by underpopulation.
2.Any live cell with more than three live neighbours dies, as if by overcrowding.
3.Any live cell with two or three live neighbours lives on to the next generation.
4.Any dead cell with exactly three live neighbours becomes a live cell.


The initial pattern constitutes the seed of the system. The first generation is created by applying the 
above rules simultaneously to every cell in the seed—births and deaths happen simultaneously, 
and the discrete moment at which this happens is sometimes called a tick 
(in other words, each generation is a pure function of the one before). 
The rules continue to be applied repeatedly to create further generations.*/


public class GameOfLife extends JFrame implements ActionListener {


    static final Color[] color = {Color.WHITE, Color.GREEN};
    // size in pixel of every label
    static final int size = 20;
    static final Dimension dim = new Dimension(size, size);

    // the cells labels
    private LifeLabel[][] label;
    // timer that fires the next feneration
    private Timer timer;
    // generation counter
    private int generation = 0;
    private JLabel generationLabel = new JLabel("Generation: 0");
    // the 3 buttons

    private JButton bClear = new JButton("Clear"),
            bPause = new JButton("Pause"),
            bGo = new JButton("Go");

    // the slider for the speed
    JSlider slider = new JSlider(0, 5000);  // 0 to 5000 milliseconds (5 seconds)
    // state of the game (running or pause)
    private boolean gameRunning = false;
    // if the mouse is down or not
    private boolean mouseDown = false;


    GameOfLife(int nbRow, int nbCol) {

        super("Game Of Life");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // create the labels (2 more on each size) these wont be shown
        // but will be used in calculating the cells alive around
        label = new LifeLabel[nbRow + 2][nbCol + 2];

        for (int r = 0; r < nbRow + 2; r++) {

            for (int c = 0; c < nbCol + 2; c++) {

                label[r][c] = new LifeLabel();
            }
        }

        // panel in the center with the labels
        JPanel panel = new JPanel(new GridLayout(nbRow, nbCol, 1, 1));
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // add each label (not the one on the border) to the panel and add to each of them its neighbours
        for (int r = 1; r < nbRow + 1; r++) {

            for (int c = 1; c < nbCol + 1; c++) {

                panel.add(label[r][c]);

                label[r][c].addNeighbour(label[r - 1][c]);    // North
                label[r][c].addNeighbour(label[r + 1][c]);    // South
                label[r][c].addNeighbour(label[r][c - 1]);    // West
                label[r][c].addNeighbour(label[r][c + 1]);    // East
                label[r][c].addNeighbour(label[r - 1][c - 1]);  // North West
                label[r][c].addNeighbour(label[r - 1][c + 1]);  // North East
                label[r][c].addNeighbour(label[r + 1][c - 1]);  // South West
                label[r][c].addNeighbour(label[r + 1][c + 1]);  // South East

            }
        }

        // now the panel can be added
        add(panel, BorderLayout.CENTER);

        // the bottom panel with the buttons the generation label and the slider
        // this panel is formed grid panels 
        panel = new JPanel(new GridLayout(1, 3));
        // another panel for the 3 buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

        bClear.addActionListener(this);
        buttonPanel.add(bClear);

        bPause.addActionListener(this);
        bPause.setEnabled(false);           // game is pause the pause button is disabled
        buttonPanel.add(bPause);

        bGo.addActionListener(this);
        buttonPanel.add(bGo);


        // add the 3 buttons to the panel
        panel.add(buttonPanel);
        // the generation label
        generationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(generationLabel);


        // the slider
        slider.setMajorTickSpacing(1000);
        slider.setMinorTickSpacing(250);
        slider.setPaintTicks(true);

        // the labels for the Slider
        Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();

        for (int i = 0; i <= 5; i++) {

            labelTable.put(new Integer(i * 1000), new JLabel("" + i));
        }

        slider.setLabelTable(labelTable);
        slider.setPaintLabels(true);

        panel.add(slider);
        // in the JFrame
        add(panel, BorderLayout.SOUTH);

        // put the frame on
        setLocation(20, 20);
        pack();
        setVisible(true);
        // start the thread that run the cycles of life
        timer = new Timer(5000 - slider.getValue(), this);
    }


    // called by the Timer and the JButtons
    public synchronized void actionPerformed(ActionEvent e) {

        // test the JButtons first
        Object o = e.getSource();
        // the clear button
        if (o == bClear) {

            timer.stop();                   // stop timer
            gameRunning = false;            // flag gamme not running

            bPause.setEnabled(false);       // disable pause button
            bGo.setEnabled(true);           // enable go button

            // clear all cells
            for (int r = 1; r < label.length - 1; r++) {

                for (int c = 1; c < label[r].length - 1; c++) {

                    label[r][c].clear();
                }
            }
            // reset generation number and its label
            generation = 0;
            generationLabel.setText("Generation: 0");
            return;
        }

        // the pause button
        if (o == bPause) {

            timer.stop();                   // stop timer
            gameRunning = false;            // flag not running
            bPause.setEnabled(false);       // disable myself
            bGo.setEnabled(true);           // enable go button
            return;
        }


        // the go button
        if (o == bGo) {

            bPause.setEnabled(true);                // enable pause button
            bGo.setEnabled(false);                  // disable myself
            gameRunning = true;                     // flag game is running
            timer.setDelay(5000 - slider.getValue());
            timer.start();
            return;
        }


        // not a JButton so it is the timer
        // set the delay for the next time
        timer.setDelay(5000 - slider.getValue());
        // if the game is not running wait for next time
        if (!gameRunning)
            return;

        ++generation;
        generationLabel.setText("Generation: " + generation);

        for (int r = 0; r < label.length; r++) {

            for (int c = 0; c < label[r].length; c++) {

                label[r][c].checkState();
            }
        }

        for (int r = 0; r < label.length; r++) {

            for (int c = 0; c < label[r].length; c++) {

                label[r][c].updateState();
            }
        }
    }

    // to start the whole thing as a Java application
    public static void main(String[] arg) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                new GameOfLife(30, 50);
            }
        });
    }


    // A class that extends JLabel but also check for the neigbour 
    // when asked to do so
    class LifeLabel extends JLabel implements MouseListener {

        private int state, newState;
        private int nbNeighbour;
        private LifeLabel[] neighbour = new LifeLabel[8];

        LifeLabel() {

            state = newState = 0;           // Dead
            setOpaque(true);                // so color will be showed
            setBackground(color[0]);
            addMouseListener(this);         // to select new LIVE cells
            this.setPreferredSize(dim);
        }

        // to add a neibour
        void addNeighbour(LifeLabel n) {

            neighbour[nbNeighbour++] = n;
        }


        // to see if I should live or not
        void checkState() {

            // number alive around
            int nbAlive = 0;

            // see the state of my neighbour
            for (int i = 0; i < nbNeighbour; i++)

                nbAlive += neighbour[i].state;

            // newState
            if (state == 1) {                // if alive

                if (nbAlive < 2)             // 1.Any live cell with fewer than two live neighbours dies
                    newState = 0;
                if (nbAlive > 3)             // 2.Any live cell with more than three live neighbours dies
                    newState = 0;
            } else {
                if (nbAlive == 3)            // 4.Any dead cell with exactly three live neighbours becomes a live cell
                    newState = 1;
            }
        }


        // after the run switch the state to new state
        void updateState() {
            if (state != newState) {     // do the test to avoid re-setting same color for nothing
                state = newState;
                setBackground(color[state]);
            }
        }

        // called when the game is reset/clear
        void clear() {

            if (state == 1 || newState == 1) {

                state = newState = 0;
                setBackground(color[state]);
            }
        }


        //        @Override
        public void mouseClicked(MouseEvent arg0) {


        }

        // if the mouse enter a cell and it is down we make the cell alive
        public void mouseEntered(MouseEvent arg0) {

            if (mouseDown) {

                state = newState = 1;
                setBackground(color[1]);
            }
        }

        //        @Override
        public void mouseExited(MouseEvent arg0) {

        }

        // if the mouse is pressed on a cell you register the fact that it is down
        // and make that cell alive
        public void mousePressed(MouseEvent arg0) {

            mouseDown = true;
            state = newState = 1;
            setBackground(color[1]);
        }

        // turn off the fact that the cell is down
        public void mouseReleased(MouseEvent arg0) {

            mouseDown = false;
        }
    }
}

