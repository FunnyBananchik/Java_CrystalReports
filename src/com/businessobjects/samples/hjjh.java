package com.businessobjects.samples;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.crystaldecisions.sdk.occa.report.application.*;
import com.crystaldecisions.sdk.occa.report.reportsource.*;
import com.crystaldecisions.ReportViewer.ReportViewerBean;

public class hjjh{
	public static void main(String[] args) {
		JFrame frame = new JFrame("Просмотр отчётов Crystal Reports");
		frame.setSize(1000, 900);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.GRAY);
		JButton preview = new JButton("Показать отчёт");
		preview.setBounds(400, 400, 200, 50);
		preview.setSize(200,100);
		preview.setBackground(new Color(25, 111, 15));
		preview.setForeground(Color.ORANGE);
        frame.setLayout(null);
		frame.getContentPane().add(preview, BorderLayout.CENTER);
		frame.setVisible(true);
		preview.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				showViewer();
				
			}
		});
	}
	

	public static void showViewer(){
		JFrame frame = new JFrame("Просмотр отчётов Crystal Reports");
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		try{
			ReportViewerBean viewer = new ReportViewerBean();
			viewer.init();
			ReportClientDocument rcd = new ReportClientDocument();
			rcd.open("C:\\Users\\Aspire\\eclipse-workspace\\LR\\Sample Reports\\Report1.rpt", OpenReportOptions._openAsReadOnly);
			IReportSource rs = rcd.getReportSource();
			viewer.setReportSource(rs);
			frame.getContentPane().add(viewer, BorderLayout.CENTER);
			frame.setVisible(true);
			viewer.start();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
