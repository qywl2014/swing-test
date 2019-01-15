package com.wulang.utils;

import javax.swing.*;
import java.awt.*;

public class GeneratePanel {
    public JPanel generateJpanel(){
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(1,4));
        jPanel.add(generateDatabaseConfigJpanel());
        jPanel.add(generatePackageConfigPanel());
        jPanel.add(generateTableConfigPanel());
        jPanel.add(generateOperatePanel());
        return jPanel;
    }

    private JPanel generateDatabaseConfigJpanel(){
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(5,1));

        JPanel hostPanel=new JPanel();
        JLabel hostLabel=new JLabel("host");
        JTextField hostText=new JTextField(9);
        hostPanel.add(hostLabel);
        hostPanel.add(hostText);
        jPanel.add(hostPanel);

        JPanel portPanel=new JPanel();
        JLabel portLabel=new JLabel("port");
        JTextField postText=new JTextField(5);
        portPanel.add(portLabel);
        portPanel.add(postText);
        jPanel.add(portPanel);

        JPanel dataBasePanel=new JPanel();
        JLabel dataBaseLabel=new JLabel("数据库名称");
        JTextField dateBaseText=new JTextField(5);
        dataBasePanel.add(dataBaseLabel);
        dataBasePanel.add(dateBaseText);
        jPanel.add(dataBasePanel);

        JPanel userNamePanel=new JPanel();
        JLabel userNameLabel=new JLabel("用户名");
        JTextField userNameText=new JTextField(5);
        userNamePanel.add(userNameLabel);
        userNamePanel.add(userNameText);
        jPanel.add(userNamePanel);

        JPanel passWordPanel=new JPanel();
        JLabel passWordLabel=new JLabel("密码");
        JTextField passWordText=new JTextField(5);
        passWordPanel.add(passWordLabel);
        passWordPanel.add(passWordText);
        jPanel.add(passWordPanel);

        return jPanel;
    }

    private JPanel generatePackageConfigPanel(){
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(3,1));

        JPanel mapperPanel=new JPanel();
        JLabel mapperLabel=new JLabel("mapper接口包名");
        JTextField mapperText=new JTextField(9);
        mapperPanel.add(mapperLabel);
        mapperPanel.add(mapperText);
        jPanel.add(mapperPanel);

        JPanel modelPanel=new JPanel();
        JLabel modelLabel=new JLabel("model类包名");
        JTextField modelText=new JTextField(9);
        modelPanel.add(modelLabel);
        modelPanel.add(modelText);
        jPanel.add(modelPanel);

        JPanel xmlPanel=new JPanel();
        JLabel xmlLabel=new JLabel("xml文件包名");
        JTextField xmlText=new JTextField(9);
        xmlPanel.add(xmlLabel);
        xmlPanel.add(xmlText);
        jPanel.add(xmlPanel);

        return jPanel;
    }

    private JPanel generateTableConfigPanel(){
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(4,1));

        JPanel tablePanel=new JPanel();
        JLabel tableLabel=new JLabel("表名");
        JTextField tableText=new JTextField(9);
        tablePanel.add(tableLabel);
        tablePanel.add(tableText);
        jPanel.add(tablePanel);

        JPanel schemaPanel=new JPanel();
        JLabel schemaLabel=new JLabel("schema名");
        JTextField schemaText=new JTextField(9);
        schemaPanel.add(schemaLabel);
        schemaPanel.add(schemaText);
        jPanel.add(schemaPanel);

        JPanel domainObjectPanel=new JPanel();
        JLabel domainObjectLabel=new JLabel("domain对象名");
        JTextField domainObjectText=new JTextField(9);
        domainObjectPanel.add(domainObjectLabel);
        domainObjectPanel.add(domainObjectText);
        jPanel.add(domainObjectPanel);

        JPanel mapperNamePanel=new JPanel();
        JLabel mapperNameLabel=new JLabel("mapper接口名");
        JTextField mapperNameText=new JTextField(9);
        mapperNamePanel.add(mapperNameLabel);
        mapperNamePanel.add(mapperNameText);
        jPanel.add(mapperNamePanel);

        return jPanel;
    }

    private JPanel generateOperatePanel(){
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(3,1));

        JButton generateButton=new JButton("生成");
        generateButton.setSize(200,200);
        jPanel.add(generateButton);

        return jPanel;
    }
}
