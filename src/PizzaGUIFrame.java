import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class PizzaGUIFrame extends JFrame
{
    JPanel wholePanel;
    JPanel crustPanel;
    JPanel sizePanel;
    JPanel toppingsPanel;
    JPanel buttonPanel;
    JPanel orderPanel;
    JPanel optionsPanel;
    JPanel optionsTwoPanel;

    JRadioButton thinCrustRB;
    JRadioButton regularCrustRB;
    JRadioButton deepdishCrustRB;

    JComboBox sizeComboBox;

    JCheckBox applesCB;
    JCheckBox bananasCB;
    JCheckBox carrotsCB;
    JCheckBox dragonfruitCB;
    JCheckBox eggsCB;
    JCheckBox fishCB;
    JCheckBox grapesCB;
    JCheckBox hazelnutCB;

    JButton orderButton;
    JButton clearButton;
    JButton quitButton;

    JTextArea orderTA;
    JScrollPane scrollPaneVariable;

    public PizzaGUIFrame()
    {
        wholePanel = new JPanel();
        wholePanel.setLayout(new BorderLayout());
        createOptionsTwoPanel();
        wholePanel.add(optionsTwoPanel, BorderLayout.NORTH);
        createOrderPanel();
        wholePanel.add(orderPanel, BorderLayout.CENTER);
        createButtonPanel();
        wholePanel.add(buttonPanel, BorderLayout.SOUTH);
        add(wholePanel);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createOptionsPanel()
    {
        optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(1,2));
        createCrustPanel();
        optionsPanel.add(crustPanel);
        createSizePanel();
        optionsPanel.add(sizePanel);
    }

    public void createOptionsTwoPanel()
    {
        optionsTwoPanel = new JPanel();
        optionsTwoPanel.setLayout(new GridLayout(2,1));
        createOptionsPanel();
        optionsTwoPanel.add(optionsPanel);
        createToppingsPanel();
        optionsTwoPanel.add(toppingsPanel);
    }

    public void createCrustPanel()
    {
        crustPanel = new JPanel();
        crustPanel.setBorder(new TitledBorder(new EtchedBorder(), "Crust"));
        crustPanel.setLayout(new GridLayout(1,3));
        thinCrustRB = new JRadioButton("Thin");
        regularCrustRB = new JRadioButton("Regular");
        deepdishCrustRB = new JRadioButton("Deep Dish");
        crustPanel.add(thinCrustRB);
        crustPanel.add(regularCrustRB);
        crustPanel.add(deepdishCrustRB);
        regularCrustRB.setSelected(true);
        ButtonGroup groupButtons = new ButtonGroup();
        groupButtons.add(thinCrustRB);
        groupButtons.add(regularCrustRB);
        groupButtons.add(deepdishCrustRB);
    }

    public void createSizePanel()
    {
        sizePanel = new JPanel();
        sizePanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
        sizeComboBox = new JComboBox();
        sizeComboBox.addItem("Small  ($8.00)");
        sizeComboBox.addItem("Medium  ($12.00)");
        sizeComboBox.addItem("Large  ($16.00)");
        sizeComboBox.addItem("Super  ($20.00)");
        sizePanel.add(sizeComboBox);
    }

    public void createToppingsPanel()
    {
        toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new GridLayout(2,4));
        toppingsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Toppings"));
        applesCB = new JCheckBox("Apples");
        bananasCB = new JCheckBox("Bananas");
        carrotsCB = new JCheckBox("Carrots");
        dragonfruitCB = new JCheckBox("Dragon Fruit");
        eggsCB = new JCheckBox("Eggs");
        fishCB = new JCheckBox("Fish");
        grapesCB = new JCheckBox("Grapes");
        hazelnutCB = new JCheckBox("Hazelnuts");
        toppingsPanel.add(applesCB);
        toppingsPanel.add(bananasCB);
        toppingsPanel.add(carrotsCB);
        toppingsPanel.add(dragonfruitCB);
        toppingsPanel.add(eggsCB);
        toppingsPanel.add(fishCB);
        toppingsPanel.add(grapesCB);
        toppingsPanel.add(hazelnutCB);
    }

    public void createButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,3));
        orderButton = new JButton("Checkout");
        orderButton.addActionListener((ActionEvent ae) ->
        {
            double costTotal = 0;

            orderTA.append("ORDER DETAILS\n");
            for(int i = 0; i < 37; i++){orderTA.append("=");}
            orderTA.append("\n");

            String sizeString =  (String) sizeComboBox.getSelectedItem();
            if(sizeString == "Small  ($8.00)"){orderTA.append("Small                         $8.00\n");costTotal = costTotal + 8;}
            else if(sizeString == "Medium  ($12.00)"){orderTA.append("Medium                       $12.00\n");costTotal = costTotal + 12;}
            else if(sizeString == "Large  ($16.00)"){orderTA.append("Large                        $16.00\n");costTotal = costTotal + 16;}
            else if(sizeString == "Super  ($20.00)"){orderTA.append("Super                        $20.00\n");costTotal = costTotal + 20;}

            if(thinCrustRB.isSelected()){orderTA.append("Thin Crust\n");}
            else if(regularCrustRB.isSelected()){orderTA.append("Regular Crust\n");}
            else if(deepdishCrustRB.isSelected()){orderTA.append("Deep Dish Crust\n");}

            orderTA.append("TOPPINGS\n");
            if(applesCB.isSelected()){orderTA.append("  Apples                      $1.00\n"); costTotal++;}
            if(bananasCB.isSelected()){orderTA.append("  Bananas                     $1.00\n");costTotal++;}
            if(carrotsCB.isSelected()){orderTA.append("  Carrots                     $1.00\n");costTotal++;}
            if(dragonfruitCB.isSelected()){orderTA.append("  Dragon Fruit                $1.00\n");costTotal++;}
            if(eggsCB.isSelected()){orderTA.append("  Eggs                        $1.00\n");costTotal++;}
            if(fishCB.isSelected()){orderTA.append("  Fish                        $1.00\n");costTotal++;}
            if(grapesCB.isSelected()){orderTA.append("  Grapes                      $1.00\n");costTotal++;}
            if(hazelnutCB.isSelected()){orderTA.append("  Hazelnuts                   $1.00\n");costTotal++;}

            double taxD = costTotal * .07;

            double totalD = costTotal + taxD;

            DecimalFormat df = new DecimalFormat("0.00");
            DecimalFormat df2 = new DecimalFormat("00.00");
            String taxF = df.format(taxD);
            String ctF = df2.format(costTotal);
            String tF = df2.format(totalD);

            orderTA.append("\n");
            orderTA.append("Sub Total                    $"+ctF+"\n");
            orderTA.append("Tax                           $"+ taxF +"\n");
            for(int i = 0; i < 37; i++){orderTA.append("-");}

            orderTA.append("\nTotal                        $"+tF+"\n");
            for(int i = 0; i < 37; i++){orderTA.append("=");}
        });
        buttonPanel.add(orderButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener((ActionEvent ae) ->
        {
            regularCrustRB.setSelected(true);
            sizeComboBox.setSelectedItem("Small  ($8.00)");
            applesCB.setSelected(false);
            bananasCB.setSelected(false);
            carrotsCB.setSelected(false);
            dragonfruitCB.setSelected(false);
            eggsCB.setSelected(false);
            fishCB.setSelected(false);
            grapesCB.setSelected(false);
            hazelnutCB.setSelected(false);
            orderTA.setText(null);
        });
        buttonPanel.add(clearButton);

        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent ae) ->
        {
            int quitI;
            quitI = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
            if (quitI == JOptionPane.YES_OPTION) {System.exit(0);}
        });
        buttonPanel.add(quitButton);
    }

    public void createOrderPanel()
    {
        orderPanel = new JPanel();
        orderTA = new JTextArea(15,40);
        orderTA.setEditable(false);
        orderTA.setFont(new Font(Font.MONOSPACED, Font.PLAIN, orderTA.getFont().getSize()));
        scrollPaneVariable = new JScrollPane(orderTA);
        orderPanel.add(scrollPaneVariable);
    }
}
