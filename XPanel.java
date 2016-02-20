package gui;
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

	public XPanel() 
	{
		//setLayout(new GridLayout(3,2));
		setLayout(null);

		JTextField txt1 = new JTextField();
		txt1.setBounds(10, 10, 205, 30);
		add(txt1);

		JButton btn7 = new JButton("7");
		btn7.setBounds(10, 50, 45, 40);
		add(btn7);
		JButton btn8 = new JButton("8");
		btn8.setBounds(60, 50, 45, 40);
		add(btn8);
		JButton btn9 = new JButton("9");
		btn9.setBounds(110, 50, 45, 40);
		add(btn9);
		JButton btndiv = new JButton("/");
		btndiv.setBounds(170, 50, 45, 40);
		add(btndiv);

		JButton btn4 = new JButton("4");
		btn4.setBounds(10, 100, 45, 40);
		add(btn4);
		JButton btn5 = new JButton("5");
		btn5.setBounds(60, 100, 45, 40);
		add(btn5);
		JButton btn6 = new JButton("6");
		btn6.setBounds(110, 100, 45, 40);
		add(btn6);
		JButton btnmult = new JButton("*");
		btnmult.setBounds(170, 100, 45, 40);
		add(btnmult);

		JButton btn1 = new JButton("1");
		btn1.setBounds(10, 150, 45, 40);
		add(btn1);
		JButton btn2 = new JButton("2");
		btn2.setBounds(60, 150, 45, 40);
		add(btn2);
		JButton btn3 = new JButton("3");
		btn3.setBounds(110, 150, 45, 40);
		add(btn3);
		JButton btnminus = new JButton("-");
		btnminus.setBounds(170, 150, 45, 40);
		add(btnminus);

		JButton btn0 = new JButton("0");
		btn0.setBounds(10, 200, 95, 40);
		add(btn0);
		JButton btndot = new JButton(".");
		btndot.setBounds(110, 200, 45, 40);
		add(btndot);

		JButton btnplus = new JButton("+");
		btnplus.setBounds(170, 200, 45, 40);
		add(btnplus);

		JButton btncalc = new JButton("=");
		btncalc.setBounds(10, 250, 145, 40);
		add(btncalc);

		JButton btncanc = new JButton("C");
		btncanc.setBounds(170, 250, 45, 40);
		add(btncanc);

		btncalc.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				st = txt1.getText().split("[+-/*]");
				try {
					a = Double.valueOf(st[0]);
					b = Double.valueOf(st[1]);
				} catch (NumberFormatException ee) 
				{
					txt1.setText("Неверные данные");
				}

				if (count_plus>0)
				{
					res = a+b;
				}
				else if (count_minus>0)
				{	
					res = a-b;
				} 
				else if (count_div>0)
				{
					if (b==0)
					{
						txt1.setText("Деление на 0");
					}
					res = a/b;
				}
				else if (count_mul>0)
				{	
					res = a*b;
				}
				else 
				{
					txt1.setText("Недостаточно данных");
				}

				txt1.setText(""+res);
				//txt1.setText(txt1.getText()+"=" + res);
				//setBackground(Color.red);
				//JOptionPane.showMessageDialog(null, txt1.getText() );
			}
		});

		btn1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"1");
			}
		});
		btn2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"2");
			}
		});
		btn3.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"3");
			}
		});
		btn4.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"4");
			}
		});
		btn5.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"5");
			}
		});
		btn6.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"6");
			}
		});
		btn7.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"7");
			}
		});
		btn8.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"8");
			}
		});
		btn9.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"9");
			}
		});
		btn0.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"0");
			}
		});
		btndot.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+".");
			}
		});
		btnplus.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//if (txt1.getText().substring(txt1.getText().length()-1)=="+")
				//{
				//JOptionPane.showMessageDialog(null, txt1.getText().length() );
				txt1.setText(txt1.getText()+"+");
				count_plus++;
				//}
			}
		});
		btnminus.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"-");
				count_minus++;
			}
		});
		btnmult.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"*");
				count_mul++;
			}
		});
		btndiv.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText(txt1.getText()+"/");
				count_div++;
			}
		});
		btncanc.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				txt1.setText("");
				count_plus=0;
				count_minus=0;
				count_mul=0;
				count_div=0;
			}
		});

	}
}
