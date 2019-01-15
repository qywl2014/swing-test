package com.wulang;

import com.wulang.utils.GeneratePanel;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame jFrame=new JFrame();
        jFrame.add(new GeneratePanel().generateJpanel());
        //使frame大小合理
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
