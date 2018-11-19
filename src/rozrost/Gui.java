package rozrost;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import org.w3c.dom.css.RGBColor;

public class Gui extends javax.swing.JFrame {

    static final int size_x = 500;              // rozmiar tablicy x
    static final int size_y = 300;              // rozmiar tablicy y
    double dT = 0;
    HandlerClass handler = new HandlerClass();
    Thread t;
    Grain boardGrain[][];
    boolean simLoop;
    private Board board;
    private boolean mC;
    private MonteCarlo monteCarlo;
    private int time;
    private boolean selectGrains = false;
    ArrayList<Integer> selectedGrainList = new ArrayList();

    public Gui() {
        time = 0;
        
        monteCarlo = new MonteCarlo();
        mC = false;
        board = new Board(size_x, size_y);                  // tworzenie tablicy
        boardGrain = new Grain[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                boardGrain[i][j] = new Grain();             // wypelnianie "planszy"
            }
        }
        initComponents();
        jLabel12.setText("Time: " + time);                  // czas jaki trwa symulacja
        ConditionsComboBox.setVisible(false);                      // TODO: UNCOMMENT TO ADD NEW NEIGHBORHOOD TYPES
        jLabel10.setVisible(false);
        recrystallizationSlider.setVisible(false);
        recrystalButton.setVisible(false);
        jLabel11.setVisible(false);
        MonteCarloToogleButton.setVisible(false);
        
        this.jLabel14.setVisible(false);
        this.jPanel5.setVisible(false);
        this.jPanel6.setVisible(false);
        this.jPanel7.setVisible(false);
        this.jPanel8.setVisible(false);
        this.probabilityOfGrowth.setVisible(false);
        this.probabilityTextField.setVisible(false);
        jLabel9.setText("" + board.getCountGrainsCristal());// ilosc ziaren
        canvas1.addMouseListener(handler);                  // dodanie obslugi myszy
        canvas1.addMouseMotionListener(handler);
        jLabel11.setText(recrystallizationSlider.getValue() + " %");       //ustawienie % rekrystalizacji w GUI
        
        this.selectionTypeBox.setVisible(false);
        this.procedGrainSelection.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        xLabelSize = new javax.swing.JLabel();
        YLabelSize = new javax.swing.JLabel();
        countXText = new javax.swing.JTextField();
        countYText = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        colorValueLabel = new javax.swing.JLabel();
        colorPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        ringSizeField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        amountRingsField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        radiusLabel = new javax.swing.JLabel();
        radiusText = new javax.swing.JTextField();
        MonteCarloToogleButton = new javax.swing.JToggleButton();
        StartButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();
        NeighborhoodComboBox = new javax.swing.JComboBox();
        ConditionsComboBox = new javax.swing.JComboBox();
        GenerateButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        NeighborhoodLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        canvas1 = new rozrost.Canvas();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        BCsButton = new javax.swing.JToggleButton();
        recrystalButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        recrystallizationSlider = new javax.swing.JSlider();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        randomSeedsCountText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inclusionsAmount = new javax.swing.JTextField();
        inclusionsSize = new javax.swing.JTextField();
        inclusionShapeComboBox = new javax.swing.JComboBox<>();
        addInclusionsButton = new javax.swing.JButton();
        probabilityTextField = new javax.swing.JTextField();
        probabilityOfGrowth = new javax.swing.JLabel();
        selectGrainsButton = new javax.swing.JButton();
        selectionTypeBox = new javax.swing.JComboBox<>();
        procedGrainSelection = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        ImportMenu = new javax.swing.JMenu();
        FromBitmapImport = new javax.swing.JMenuItem();
        FromTextFileImport = new javax.swing.JMenuItem();
        ExportMenu = new javax.swing.JMenu();
        ToBitmapExport = new javax.swing.JMenuItem();
        ToTextFileExport = new javax.swing.JMenuItem();
        showGrainsBorders = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(1150, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(1150, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel8.setText("Seeds count");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 2);
        jPanel9.add(jLabel8, gridBagConstraints);

        jLabel9.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel9.add(jLabel9, gridBagConstraints);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSeparator2.setMinimumSize(new java.awt.Dimension(1, 20));
        jSeparator2.setPreferredSize(new java.awt.Dimension(1, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel9.add(jSeparator2, gridBagConstraints);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jSeparator1.setMinimumSize(new java.awt.Dimension(1, 20));
        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        jPanel9.add(jSeparator1, gridBagConstraints);

        jLabel12.setText("time: 0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel9.add(jLabel12, gridBagConstraints);

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jPanel2.setLayout(new java.awt.GridBagLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel6.setLayout(new java.awt.GridBagLayout());

        xLabelSize.setText("X:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(xLabelSize, gridBagConstraints);

        YLabelSize.setText("Y:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel6.add(YLabelSize, gridBagConstraints);

        countXText.setText("10");
        countXText.setMinimumSize(new java.awt.Dimension(40, 22));
        countXText.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel6.add(countXText, gridBagConstraints);

        countYText.setText("10");
        countYText.setMinimumSize(new java.awt.Dimension(40, 22));
        countYText.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
        jPanel6.add(countYText, gridBagConstraints);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 200, -1, -1));

        jPanel5.setLayout(new java.awt.GridBagLayout());
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 400, -1, -1));

        jPanel4.setLayout(new java.awt.GridBagLayout());

        idLabel.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(idLabel, gridBagConstraints);

        colorValueLabel.setFont(new java.awt.Font("Dialog", 0, 9)); // NOI18N
        colorValueLabel.setText("(0,0,0)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(colorValueLabel, gridBagConstraints);

        colorPanel.setMinimumSize(new java.awt.Dimension(70, 25));
        colorPanel.setPreferredSize(new java.awt.Dimension(70, 25));
        colorPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(colorPanel, gridBagConstraints);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        jPanel7.setLayout(new java.awt.GridBagLayout());

        ringSizeField.setText("5");
        ringSizeField.setMinimumSize(new java.awt.Dimension(40, 22));
        ringSizeField.setName(""); // NOI18N
        ringSizeField.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 5, 5);
        jPanel7.add(ringSizeField, gridBagConstraints);

        jLabel4.setText("Promień:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel7.add(jLabel4, gridBagConstraints);

        amountRingsField.setText("5");
        amountRingsField.setMinimumSize(new java.awt.Dimension(40, 22));
        amountRingsField.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        jPanel7.add(amountRingsField, gridBagConstraints);

        jLabel5.setText("Ilość pkt:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 2, 5);
        jPanel7.add(jLabel5, gridBagConstraints);

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, -1, -1));

        jPanel8.setLayout(new java.awt.GridBagLayout());

        radiusLabel.setText("Promień:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel8.add(radiusLabel, gridBagConstraints);

        radiusText.setText("10");
        radiusText.setMinimumSize(new java.awt.Dimension(40, 22));
        radiusText.setPreferredSize(new java.awt.Dimension(40, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel8.add(radiusText, gridBagConstraints);

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, -1, -1));

        MonteCarloToogleButton.setText("Monte Carlo");
        MonteCarloToogleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonteCarloToogleButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MonteCarloToogleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 150, 140));

        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });
        jPanel1.add(StartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 110, 60));

        StopButton.setText("Stop");
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });
        jPanel1.add(StopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, 110, 60));

        NeighborhoodComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Moore", "von Neumann'a", "Hexagonal (left)", "Hexagonal (right)", "Hexagonal (random)", "Pentagonal", "Random", "Radius", "Extended Moore" }));
        NeighborhoodComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                NeighborhoodComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        NeighborhoodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NeighborhoodComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(NeighborhoodComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 160, 30));

        ConditionsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Losowe", "Stała odległość", "Stała ilość ziaren" }));
        ConditionsComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ConditionsComboBoxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(ConditionsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 330, 160, 30));

        GenerateButton.setText("Generate");
        GenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateButtonActionPerformed(evt);
            }
        });
        jPanel1.add(GenerateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 120, 60));

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        jPanel1.add(ClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 120, 60));

        NeighborhoodLabel.setText("Neighborhood");
        jPanel1.add(NeighborhoodLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 240, -1, -1));

        jLabel14.setText("Conditions");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, -1, -1));

        canvas1.setPreferredSize(new java.awt.Dimension(500, 300));

        jPanel3.setMinimumSize(new java.awt.Dimension(500, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 300));
        jPanel3.setLayout(new java.awt.GridBagLayout());
        canvas1.add(jPanel3);
        jPanel3.setBounds(-120, -10, 500, 300);

        jPanel1.add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        BCsButton.setText("Perdiodic BC");
        BCsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCsButtonActionPerformed(evt);
            }
        });
        jPanel10.add(BCsButton);

        recrystalButton.setText("Rekrystalizacja");
        recrystalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recrystalButtonActionPerformed(evt);
            }
        });
        jPanel10.add(recrystalButton);

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 230, 40));

        jLabel10.setText("Rekrystalizje: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, -1, -1));

        recrystallizationSlider.setMinimumSize(new java.awt.Dimension(100, 16));
        recrystallizationSlider.setPreferredSize(new java.awt.Dimension(100, 16));
        recrystallizationSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                recrystallizationSliderStateChanged(evt);
            }
        });
        jPanel1.add(recrystallizationSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, -1, -1));

        jLabel11.setText("0 %");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, -1, -1));

        jLabel3.setText("Seeds count");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 200, -1, -1));

        randomSeedsCountText.setText("10");
        randomSeedsCountText.setMinimumSize(new java.awt.Dimension(40, 22));
        randomSeedsCountText.setPreferredSize(new java.awt.Dimension(40, 22));
        jPanel1.add(randomSeedsCountText, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, -1, -1));

        jLabel1.setText("Amount of inclusions ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, -1, -1));

        jLabel2.setText("Size of inclusions");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, -1, -1));

        jLabel6.setText("inclusions shape");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 460, -1, -1));

        inclusionsAmount.setText("10");
        inclusionsAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inclusionsAmountActionPerformed(evt);
            }
        });
        jPanel1.add(inclusionsAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 120, -1));

        inclusionsSize.setText("5");
        inclusionsSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inclusionsSizeActionPerformed(evt);
            }
        });
        jPanel1.add(inclusionsSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 480, 100, -1));

        inclusionShapeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "square", "circular" }));
        inclusionShapeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inclusionShapeComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(inclusionShapeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, 90, -1));

        addInclusionsButton.setText("Add Inclusions");
        addInclusionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInclusionsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addInclusionsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 465, 120, 40));

        probabilityTextField.setText("90");
        jPanel1.add(probabilityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 40, -1));

        probabilityOfGrowth.setText("Probability of growth");
        jPanel1.add(probabilityOfGrowth, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, -1, -1));

        selectGrainsButton.setText("Select Grains");
        selectGrainsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectGrainsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(selectGrainsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, 110, 40));

        selectionTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selection DualPhase", "Selection NewPhase", "Get Boundaries" }));
        selectionTypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectionTypeBoxActionPerformed(evt);
            }
        });
        jPanel1.add(selectionTypeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 520, 150, 40));

        procedGrainSelection.setText("Proced");
        procedGrainSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procedGrainSelectionActionPerformed(evt);
            }
        });
        jPanel1.add(procedGrainSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 520, 100, 40));

        getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

        ImportMenu.setText("Import");
        ImportMenu.setToolTipText("");

        FromBitmapImport.setText("From Bitmap");
        FromBitmapImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FromBitmapImportActionPerformed(evt);
            }
        });
        ImportMenu.add(FromBitmapImport);

        FromTextFileImport.setText("From TextFile");
        FromTextFileImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FromTextFileImportActionPerformed(evt);
            }
        });
        ImportMenu.add(FromTextFileImport);

        jMenuBar1.add(ImportMenu);

        ExportMenu.setText("Export");

        ToBitmapExport.setText("To bitmap");
        ToBitmapExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToBitmapExportActionPerformed(evt);
            }
        });
        ExportMenu.add(ToBitmapExport);

        ToTextFileExport.setText("To text file");
        ToTextFileExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToTextFileExportActionPerformed(evt);
            }
        });
        ExportMenu.add(ToTextFileExport);

        showGrainsBorders.setSelected(true);
        showGrainsBorders.setText("Show grains boarders");
        ExportMenu.add(showGrainsBorders);

        jMenuBar1.add(ExportMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private BufferedImage map( int sizeX, int sizeY, boolean showBoundary){
    final BufferedImage res = new BufferedImage( sizeX, sizeY, BufferedImage.TYPE_INT_RGB );
            for(int j=0;j<size_y;j++){
            for(int i=0;i<size_x;i++){
                if(boardGrain[i][j].getId() == 0 || (boardGrain[i][j].isB()) && showBoundary ){
                    res.setRGB(i,j, Color.BLACK.getRGB() );
                }else{
                    int R = boardGrain[i][j].getR();
                    int G = boardGrain[i][j].getG();
                    int B = boardGrain[i][j].getB();
                    int grain = boardGrain[i][j].getId();
              
                    res.setRGB(i,j, new Color(R,G,B).getRGB() );
                }
            } 
        }
    return res;
    }
    
    private static void saveBMP( final BufferedImage bi, final String path ){
        try {
            RenderedImage rendImage = bi;
            ImageIO.write(rendImage, "bmp", new File(path));
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    private void ToBitmapExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToBitmapExportActionPerformed
        BufferedImage img = map( size_x, size_y, showGrainsBorders.isSelected());
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");   
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            saveBMP( img, fileToSave.getAbsolutePath() + ".bmp" );
        }
    }//GEN-LAST:event_ToBitmapExportActionPerformed

    private void recrystallizationSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_recrystallizationSliderStateChanged
        jLabel11.setText(recrystallizationSlider.getValue() + " %");
        board.setRecrystalPercent(recrystallizationSlider.getValue());
    }//GEN-LAST:event_recrystallizationSliderStateChanged

    private void recrystalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recrystalButtonActionPerformed
        time = 0;
        jLabel12.setText("Czas: " + time);
        if (t != null) {
            t.stop();
        }

        t = new Thread(new Runnable() {
            @Override
            public void run() {
                reSim();
            }
        });
        t.start();
    }//GEN-LAST:event_recrystalButtonActionPerformed

    private void BCsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCsButtonActionPerformed
        board.changePeriodic();
        monteCarlo.changePerio();
    }//GEN-LAST:event_BCsButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        time = 0;                                                      // zeruje czas
        jLabel12.setText("Czas: " + time);                              // ustawia wyzerowany czas
        boardGrain = board.clear();                                     // czyscimy nasza "plansze"
        canvas1.setGrains(boardGrain);                                  // pokazujemy wyczyszczoną "plansze"
        canvas1.repaint();
        jLabel9.setText("" + board.getCountGrainsCristal());
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void GenerateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateButtonActionPerformed
        if (mC) {
            monteCarlo = new MonteCarlo(size_x, size_y, Integer.parseInt(randomSeedsCountText.getText()));
            boardGrain = monteCarlo.randomBoard();
            canvas1.setGrains(boardGrain);
            canvas1.repaint();
        } else {
            //boardGrain = board.clear();           
            boardGrain = board.randomBoard(ConditionsComboBox.getSelectedIndex(),  
                Integer.parseInt(countXText.getText()),                 
                Integer.parseInt(countYText.getText()),                
                Integer.parseInt(randomSeedsCountText.getText()),
                Integer.parseInt(ringSizeField.getText()),              
                Integer.parseInt(amountRingsField.getText()));          
            canvas1.setGrains(boardGrain);                                  
            canvas1.repaint();                                              
            jLabel9.setText("" + board.getCountGrainsCristal());
        }
    }//GEN-LAST:event_GenerateButtonActionPerformed

    private void ConditionsComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ConditionsComboBoxPopupMenuWillBecomeInvisible
        switch (ConditionsComboBox.getSelectedIndex()) {
            case 0:
            this.jPanel5.setVisible(false);
            this.jPanel6.setVisible(false);
            this.jPanel7.setVisible(false);
            break;
            case 2:
            this.jPanel5.setVisible(true);
            this.jPanel6.setVisible(false);
            this.jPanel7.setVisible(false);
            break;
            case 1:
            this.jPanel5.setVisible(false);
            this.jPanel6.setVisible(true);
            this.jPanel7.setVisible(false);
            break;
            case 3:
            this.jPanel5.setVisible(false);
            this.jPanel6.setVisible(false);
            this.jPanel7.setVisible(true);
            break;
            default:
            break;
        }
    }//GEN-LAST:event_ConditionsComboBoxPopupMenuWillBecomeInvisible

    private void NeighborhoodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NeighborhoodComboBoxActionPerformed

    }//GEN-LAST:event_NeighborhoodComboBoxActionPerformed

    private void NeighborhoodComboBoxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_NeighborhoodComboBoxPopupMenuWillBecomeInvisible
        switch (NeighborhoodComboBox.getSelectedIndex()) {        // pokazywanie menu
            case 7:
            this.jPanel8.setVisible(true);
            break;
            case 8:
                this.probabilityOfGrowth.setVisible(true);
                this.probabilityTextField.setVisible(true);
            break;
            default:
            this.jPanel8.setVisible(false);
            break;
        }
    }//GEN-LAST:event_NeighborhoodComboBoxPopupMenuWillBecomeInvisible

    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonActionPerformed
        if (t != null) {                          // zatrzymujemy symulacje
            t.stop();
        }
    }//GEN-LAST:event_StopButtonActionPerformed

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        time = 0;
        jLabel12.setText("Czas: " + time);      // czas jaki trwa symulacja
        if (t != null) {                        // zatrzymujemy symulacje
            t.stop();
        }
        t = new Thread(new Runnable() {         // tworzymy nowy watek, ktory bedzie oblugiwał symulacje
            @Override
            public void run() {
                sim();
            }
        });
        t.start();                              // startujemy symulacje
    }//GEN-LAST:event_StartButtonActionPerformed

    private void MonteCarloToogleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonteCarloToogleButtonActionPerformed
        mC = !mC;
        this.jPanel5.setVisible(mC);
    }//GEN-LAST:event_MonteCarloToogleButtonActionPerformed
    
    private void FromBitmapImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FromBitmapImportActionPerformed
        try {
            //openFile; 
            HashSet<Color> treeSet = new HashSet<>();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");   
            int userSelection = fileChooser.showSaveDialog(this);
           
            File bmpFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
            BufferedImage image = ImageIO.read(bmpFile);
            if(image.getHeight()== size_y && image.getWidth() == size_y);
            {
                for(int y=0;y<size_y;y++){
                    for(int x=0;x<size_x;x++){
                        int clr=  image.getRGB(x,y); 
                        int  red   = (clr & 0x00ff0000) >> 16;
                        int  green = (clr & 0x0000ff00) >> 8;
                        int  blue  =  clr & 0x000000ff;
                        boardGrain[x][y].setRGB(red, green, blue);
                        if( red == 255 && blue == 255 && green == 255) {
                            boardGrain[x][y].setId(-1);
                            continue;
                        }
                        treeSet.add(new Color(red,green,blue));
                    }
                }
            }
            
            HashMap<Color, Integer> colorMapping = new HashMap<Color, Integer>();
            int uniq_id = 1;
            Color white = new Color(255,255,255);
            for(Color cl : treeSet)
            {
                if(cl == white)
                {
                    System.err.println("KOLOR JEST BIALY");
                    colorMapping.put(cl, -1);
                }
                else
                {
                    colorMapping.put(cl, uniq_id);
                    uniq_id++;
                }
            }
            for(int y=0;y<size_y;y++){
                for(int x=0;x<size_x;x++){
                    if (boardGrain[x][y].getId() != -1)
                        boardGrain[x][y].setId(colorMapping.get(new Color(boardGrain[x][y].getR(),boardGrain[x][y].getG(),boardGrain[x][y].getB()))); 
                    }
            }
            boardGrain = board.edge();
            canvas1.setGrains(boardGrain);
            canvas1.repaint();
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_FromBitmapImportActionPerformed

    private void ToTextFileExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToTextFileExportActionPerformed
        PrintWriter writer = null;
        try {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");   
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            writer = new PrintWriter(fileToOpen, "UTF-8");
            
            for(int y=0;y<size_y;y++){    
                for(int x=0;x<size_x;x++){
                    writer.println(boardGrain[x][y].getId() + "," 
                            + x + "," + y+ ","
                            + boardGrain[x][y].getR() + "," 
                            + boardGrain[x][y].getG() + "," 
                            + boardGrain[x][y].getB());
                }
            }
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }//GEN-LAST:event_ToTextFileExportActionPerformed

    private void FromTextFileImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FromTextFileImportActionPerformed

            try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");            
            int userSelection = fileChooser.showSaveDialog(this);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToOpen = fileChooser.getSelectedFile();
                BufferedReader in = new BufferedReader(new FileReader(fileToOpen));
                while(true){
                    String line = in.readLine();
                    if(line == null ) break;
                    String[] propperties = line.split(",");
                    int id = Integer.parseInt(propperties[0]);
                    int x = Integer.parseInt(propperties[1]);		
                    int y = Integer.parseInt(propperties[2]);
                    int R = Integer.parseInt(propperties[3]);
                    int G = Integer.parseInt(propperties[4]);
                    int B = Integer.parseInt(propperties[5]);
                    boardGrain[x][y].setId(id);
                    boardGrain[x][y].setRGB(R,G,B); 
                }          
            }
        } catch (HeadlessException headlessException) {
        } catch (FileNotFoundException fileNotFoundException) {
        } catch (IOException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            boardGrain = board.edge();
            canvas1.setGrains(boardGrain);
            canvas1.repaint();
    }//GEN-LAST:event_FromTextFileImportActionPerformed

    private void inclusionsAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inclusionsAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inclusionsAmountActionPerformed

    private void inclusionsSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inclusionsSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inclusionsSizeActionPerformed

    private void inclusionShapeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inclusionShapeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inclusionShapeComboBoxActionPerformed

    private void addInclusionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInclusionsButtonActionPerformed
        int size = Integer.parseInt(inclusionsSize.getText());
        int amount = Integer.parseInt(inclusionsAmount.getText());
        int shape = inclusionShapeComboBox.getSelectedIndex();
        int x0 = 0;
        int y0 = 0;
        Random rand = new Random();
       
        ArrayList<Grain> grainList = board.getGrainsOnBorder();

        for(int attempt = 0; attempt< amount; attempt++)
        {
            if(board.isEdgeGenerated()){
                int randomGrainIndex = rand.nextInt(grainList.size());
                Grain randomGrain = grainList.get(randomGrainIndex);  
                x0 = randomGrain.getX();
                y0 = randomGrain.getY();
            }
            else{
                x0 = rand.nextInt(size_x);
                y0 = rand.nextInt(size_y);
            }
            
            if (shape == 0)
            {
                int a = (int)((size/1.44)/2);    
                for(int stepX = -a; stepX <a; stepX++)
                {
                    for(int stepY = -a; stepY <a; stepY++)
                    {
                        if(x0+stepX < size_x && x0+stepX > 0 && y0+stepY < size_y && y0+stepY >0 )
                        {
                            boardGrain[x0+stepX][y0+stepY].setId(-1);
                            boardGrain[x0+stepX][y0+stepY].setRGB(255,255,255);
                        }
                    }
                }
            }
            else {
                for(int y=-size; y<=size; y++)
                    for(int x=-size; x<=size; x++)
                        if(x*x+y*y <= size*size && x0+x < size_x && x0+x>0 && y0+y < size_y && y0+y>0)
                            boardGrain[x0+x][y0+y].setId(-1);
            }       
        }
        boardGrain = board.edge();
        canvas1.setGrains(boardGrain);
        canvas1.repaint();
        
    }//GEN-LAST:event_addInclusionsButtonActionPerformed

    private void selectGrainsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectGrainsButtonActionPerformed
        selectedGrainList.clear();
        this.selectGrains = !this.selectGrains;
        this.selectionTypeBox.setVisible(this.selectGrains);
        this.procedGrainSelection.setVisible(this.selectGrains);
        
    }//GEN-LAST:event_selectGrainsButtonActionPerformed

    private void selectionTypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectionTypeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectionTypeBoxActionPerformed

    private void procedGrainSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procedGrainSelectionActionPerformed
        if (this.selectionTypeBox.getSelectedIndex() == 1 || this.selectionTypeBox.getSelectedIndex() == 0 )
            boardGrain = board.removeAllGrainsExceptSeleected(selectedGrainList);
        
        if (this.selectionTypeBox.getSelectedIndex() == 1) 
            boardGrain = board.dualPhaseIdChange();
        
        if ( this.selectionTypeBox.getSelectedIndex() == 2)
        {
            boardGrain = board.growBoundaries(2, selectedGrainList);
        }
       canvas1.setGrains(boardGrain);
       canvas1.repaint();
    }//GEN-LAST:event_procedGrainSelectionActionPerformed

    private void sim() {

        if (mC) {
            simLoop = true;
            while (simLoop) {
                time++;
                jLabel12.setText("Czas: " + time);
                boardGrain = monteCarlo.calculate();
                canvas1.setGrains(boardGrain);
                canvas1.repaint();
                if (monteCarlo.getChanged() == 0) {
                    simLoop = false;
                }
            }
        } else {
            simLoop = true;
            while (simLoop) {
                time++;
                jLabel12.setText("Czas: " + time);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
                board.setGrainsToSkip(selectedGrainList);
                boardGrain = board.calculate(NeighborhoodComboBox.getSelectedIndex(),
                        Integer.parseInt(radiusText.getText()), 
                        Integer.parseInt(probabilityTextField.getText()));
                
                simLoop = board.ammountOfNotEmptyCells() != (size_x * size_y);
                canvas1.setGrains(boardGrain);
                canvas1.repaint();

                if (!simLoop) {
                    boardGrain = board.edge();
                    jLabel9.setText("" + board.getCountGrainsCristal());
                    t.stop();
                }
            }
        }

    }

    private void reSim() {

        if (mC) {
            monteCarlo = new MonteCarlo(size_x, size_y, boardGrain);
            simLoop = true;
            while (simLoop) {
                time++;
                jLabel12.setText("Czas: " + time);
                boardGrain = monteCarlo.calculate();
                canvas1.setGrains(boardGrain);
                canvas1.repaint();
                if (monteCarlo.getChanged() == 0) {
                    simLoop = false;
                }
            }
        } else {
            simLoop = true;
            while (simLoop) {
                time++;
                jLabel12.setText("Czas: " + time);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }

                dT += 0.001;
                boardGrain = board.reCalculate(NeighborhoodComboBox.getSelectedIndex(), dT);
                simLoop = board.recrystal() != (size_x * size_y);
                canvas1.setGrains(boardGrain);
                canvas1.repaint();
                jLabel9.setText("" + board.getCountGrainsRecristal());
                if (!simLoop) {
                    boardGrain = board.edge();
                    board.clearRecrystal();
                    t.stop();
                }
            }
        }

    }

    public class HandlerClass implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if(selectGrains)
                addGrainToListOnMouseClick(e.getX(), e.getY());
            else
                mouseC(e.getX(), e.getY());
            
        }

        int xPres, yPres;

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            mauseM(e.getX(), e.getY());
        }

    }

    private void mauseM(int i, int j) {

        int R = boardGrain[i][j].getR();
        int G = boardGrain[i][j].getG();
        int B = boardGrain[i][j].getB();
        int grain = boardGrain[i][j].getId();  // pobieranie aktualnego ziarna, na ktorym jest myszka  i obliczanie jego RGB
        idLabel.setText("" + boardGrain[i][j].getId());
        colorValueLabel.setText("(" + R + "," + G + "," + B + ")" + "     " + boardGrain[i][j].isB());
        colorPanel.setBackground(new Color(R, G, B));
    }

    private void mouseC(int x, int y) {                  // funkcja dodajaca nowe ziarno myszka
        int xp = (int) Math.floor(x / (500 / size_x));
        int yp = (int) Math.floor(y / (300 / size_y));
        boardGrain = board.addGrain(xp, yp);
        canvas1.setGrains(boardGrain);
        canvas1.repaint();
        jLabel9.setText("" + board.getCountGrainsCristal());
    }
    
    private void addGrainToListOnMouseClick(int x, int y)
    {
        selectedGrainList.add(boardGrain[x][y].getId());
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("CDE/Motif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
                
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BCsButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JComboBox ConditionsComboBox;
    private javax.swing.JMenu ExportMenu;
    private javax.swing.JMenuItem FromBitmapImport;
    private javax.swing.JMenuItem FromTextFileImport;
    private javax.swing.JButton GenerateButton;
    private javax.swing.JMenu ImportMenu;
    private javax.swing.JToggleButton MonteCarloToogleButton;
    private javax.swing.JComboBox NeighborhoodComboBox;
    private javax.swing.JLabel NeighborhoodLabel;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton StopButton;
    private javax.swing.JMenuItem ToBitmapExport;
    private javax.swing.JMenuItem ToTextFileExport;
    private javax.swing.JLabel YLabelSize;
    private javax.swing.JButton addInclusionsButton;
    private javax.swing.JTextField amountRingsField;
    private rozrost.Canvas canvas1;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JLabel colorValueLabel;
    private javax.swing.JTextField countXText;
    private javax.swing.JTextField countYText;
    private javax.swing.JLabel idLabel;
    private javax.swing.JComboBox<String> inclusionShapeComboBox;
    private javax.swing.JTextField inclusionsAmount;
    private javax.swing.JTextField inclusionsSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel probabilityOfGrowth;
    private javax.swing.JTextField probabilityTextField;
    private javax.swing.JButton procedGrainSelection;
    private javax.swing.JLabel radiusLabel;
    private javax.swing.JTextField radiusText;
    private javax.swing.JTextField randomSeedsCountText;
    private javax.swing.JButton recrystalButton;
    private javax.swing.JSlider recrystallizationSlider;
    private javax.swing.JTextField ringSizeField;
    private javax.swing.JButton selectGrainsButton;
    private javax.swing.JComboBox<String> selectionTypeBox;
    private javax.swing.JRadioButtonMenuItem showGrainsBorders;
    private javax.swing.JLabel xLabelSize;
    // End of variables declaration//GEN-END:variables
}
