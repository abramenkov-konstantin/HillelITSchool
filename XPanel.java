package gui;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class XPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private static int count_plus = 0;
	private static int count_minus = 0;
	private static int count_div = 0;
	private static int count_mul = 0;
	private static Double a,b, res;
	private static String [] st;
	JTextField txt = new JTextField();

	public XPanel() 
	{
		setLayout(null);

		//JTextField txt = new JTextField();
		txt.setBounds(10, 10, 260, 40);
		add(txt);

		JPanel pNum = new JPanel();
		pNum.setLayout(new GridLayout(4, 3, 10, 10));
		pNum.setBounds(10, 60, 200, 200);
		pNum.setBackground(Color.red);
		add(pNum);

		JPanel pOp = new JPanel();
		pOp.setLayout(new GridLayout(4, 1, 10, 10));
		pOp.setBounds(220, 60, 50, 200);
		pOp.setBackground(Color.yellow);
		add(pOp);
		
		JButton btncalc = new JButton("=");
		btncalc.setBounds(10, 265, 200, 40);
		btncalc.setBackground(Color.green);
		add(btncalc);
		
		btncalc.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				res=calc(txt.getText());	
				txt.setText(""+res);
			}
		});

		JButton btncanc = new JButton("C");
		btncanc.setBounds(220, 265, 50, 40);
		btncanc.setBackground(Color.magenta);
		add(btncanc);
		
		btncanc.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt.setText("");
				count_plus=0;
				count_minus=0;
				count_mul=0;
				count_div=0;
			}
		});
		
		ActionNum aNum = new ActionNum();
		String[] strNum = {"7","8","9","4","5","6","1","2","3","0","."};
		for (int i = 0; i < strNum.length; i++)
		{
			JButton btn = new JButton(strNum[i]);
			btn.addActionListener(aNum);
			pNum.add(btn);		
		}		

		ActionOp aOp = new ActionOp();
		String[] strOp = {"+","-","/","*"};		
		for (int i = 0; i < strOp.length; i++)
		{
			JButton btn = new JButton(strOp[i]);
			btn.addActionListener(aOp);
			pOp.add(btn);		
		}		
	}

	class ActionNum implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent ee) 
		{
			String str = ee.getActionCommand();
			txt.setText( txt.getText() + str );
		}	
	}
	class ActionOp implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent eo) 
		{
			String str = eo.getActionCommand();
			if (str=="+") count_plus++;
			if (str=="-") count_minus++;
			if (str=="*") count_mul++;
			if (str=="/") count_div++;
			txt.setText( txt.getText() + str);
		}
	}
	
	public double calc (String tx)
	{
		st = tx.split("[+-/*]");
		try {
			a = Double.valueOf(st[0]);
			b = Double.valueOf(st[1]);
		} catch (NumberFormatException ee) 
		{
			txt.setText("Неверные данные");
		}
		if (count_plus>0) res = a+b;
		if (count_minus>0) res = a-b;
		if (count_div>0) res = a/b;
		if (count_mul>0) res = a*b;
				
		return res;
	}
}
