package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

	private JFrame frame;
	private JButton btnNotIT;
	private JButton btnIsIT;
	private JLabel lblTag;
	private Queue<String> tagQue;
	private Queue<String> ITtagQue;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		tagQue = new LinkedList<String>();
		ITtagQue = new LinkedList<String>();
		load("D:\\tags.txt");
		if(tagQue.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Tag集合为空");
			return;
		}
		lblTag.setText(tagQue.poll());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				keyBoard(arg0);
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		lblTag = new JLabel("New label");
		springLayout.putConstraint(SpringLayout.NORTH, lblTag, 38, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblTag, 51, SpringLayout.WEST, frame.getContentPane());
		lblTag.setHorizontalAlignment(SwingConstants.CENTER);
		lblTag.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		frame.getContentPane().add(lblTag);
		
		btnIsIT = new JButton("\u5C5E\u4E8EIT\u7C7B");
		springLayout.putConstraint(SpringLayout.NORTH, btnIsIT, 123, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnIsIT, 51, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnIsIT, -82, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnIsIT, 144, SpringLayout.WEST, frame.getContentPane());
		btnIsIT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				isIT(arg0);
			}
		});
		frame.getContentPane().add(btnIsIT);
		
		btnNotIT = new JButton("\u4E0D\u5C5E\u4E8EIT\u7C7B");
		btnNotIT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				notIT(arg0);
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, lblTag, 0, SpringLayout.EAST, btnNotIT);
		springLayout.putConstraint(SpringLayout.NORTH, btnNotIT, 0, SpringLayout.NORTH, btnIsIT);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNotIT, 0, SpringLayout.SOUTH, btnIsIT);
		springLayout.putConstraint(SpringLayout.EAST, btnNotIT, -59, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNotIT);
	}

	protected void keyBoard(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	protected void notIT(MouseEvent arg0) {
		// TODO Auto-generated method stub
		nextTag();
	}

	protected void isIT(MouseEvent arg0) {
		ITtagQue.add(lblTag.getText());
		nextTag();
	}
	
	private void nextTag()
	{
		if(tagQue.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "处理完毕");
			save();
			return;
		}
		lblTag.setText(tagQue.poll());
	}
	
	private void save() {
		String path = null;
		File file = null;
		FileWriter fw = null;
		String tag = null;
		
		try {
			path = "D:\\ITtags.txt";
			fw = new FileWriter(new File(path));
			while(!ITtagQue.isEmpty())
			{
				tag = ITtagQue.poll();
				fw.write(tag);
				fw.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null)
			{
				try {
					fw.flush();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}

	private void load(String path)
	{
		File file = null;
		BufferedReader br = null;
		String tag = null;
		Set<String> tagSet;
		int i = 0;
		try {
			tagSet = new HashSet<String>();
			file = new File(path);
			br = new BufferedReader(new FileReader(file));
			while((tag = br.readLine()) != null)
			{
				tagSet.add(tag);
				i++;
			}
			tagQue = new LinkedList<String>(tagSet);
			System.out.println(tagQue.size());
			System.out.println(i);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(br != null)
			{
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
