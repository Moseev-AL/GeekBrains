import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private String display = "";

    public MyWindow() {
        //Доработки:
        //Добавить еще 3 кнопки внизу
        //C - clear |    [empty button]   |  D - dial
        //Реализовать действия данных кнопок в графическом виде по своему усмотрению

        //Задача со звездочкой - не обязательная, выполняется вместо доработок
        //Реализовать вместо номеронаберателя калькулятор

        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 150, 300);

        setLayout(new FlowLayout());
        JButton[] jbs = new JButton[12];
        JPanel jPanel1 = new JPanel();

        JTextField field = new JTextField("", 10);
        jPanel1.add(field);


        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Message :" + field.getText());
            }
        });
        jPanel1.setBounds(0, 0, 150, 50);

        JPanel jPanel2 = new JPanel();
        jPanel2.setBounds(0, 0, 150, 250);

        jPanel2.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 12; i++) {
            jbs[i] = new JButton("" + (i + 1));
            if (i == 10) {
                jbs[i].setText("0");
            }
            if (i == 9) {
                jbs[i].setText("#");
            }
            if (i == 11) {
                jbs[i].setText("*");
            }
            jPanel2.add(jbs[i]);
        }
        jbs[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "1";
                field.setText(display);
            }
        });
        jbs[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "2";
                field.setText(display);
            }
        });
        jbs[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "3";
                field.setText(display);
            }
        });
        jbs[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "4";
                field.setText(display);
            }
        });
        jbs[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "5";
                field.setText(display);
            }
        });
        jbs[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "6";
                field.setText(display);
            }
        });
        jbs[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "7";
                field.setText(display);
            }
        });

        jbs[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "8";
                field.setText(display);
            }
        });

        jbs[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "9";
                field.setText(display);
            }
        });

        jbs[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "#";
                field.setText(display);
            }
        });

        jbs[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "0";
                field.setText(display);
            }
        });

        jbs[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = display + "*";
                field.setText(display);
            }
        });

// ///////////////////////////////////
        JPanel jPanel3 = new JPanel();
        jPanel3.setBounds(0, 0, 150, 250);
        JButton buttonClear = new JButton("Clear");
        JButton buttonEmpty = new JButton("");
        buttonEmpty.setVisible(false);
        JButton buttonDeal = new JButton("Deal");
        jPanel3.add(buttonClear);

        jPanel3.add(buttonDeal);

        JPanel statusPanel = new JPanel();

        statusPanel.setPreferredSize(new Dimension(getWidth()-20, 20));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display = "";
                field.setText(display);
            }
        });
        buttonDeal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Calling...");
            }
        });
// //////////////////////////////////////////////////////

        add(jPanel1);
        add(jPanel2);
        add(jPanel3);
        add(statusPanel);
        setVisible(true);
    }

}
