import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;


public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5125898677456011046L;
	private JPanel contentPane;
	private JTextField txtClientNum;
	private JTextField txtLicenseNum;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtPath;
	private JTextField txtSecLocation;
	private JTextField txtFirstLocation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05DC\u05E7\u05D5\u05D7 : ");
		
		JLabel label_1 = new JLabel("\u05E8\u05D9\u05E9\u05D9\u05D5\u05DF : ");
		
		txtClientNum = new JTextField();
		txtClientNum.setColumns(10);
		
		txtLicenseNum = new JTextField();
		txtLicenseNum.setColumns(10);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		
		JLabel label_2 = new JLabel("\u05E9\u05DD \u05D4\u05DE\u05E9\u05EA\u05DE\u05E9 : ");
		
		JLabel label_3 = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D0 : ");
		
		JLabel label_4 = new JLabel("\u05E0\u05EA\u05D9\u05D1 : ");
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		
		txtPath = new JTextField();
		txtPath.setColumns(10);
		
		txtSecLocation = new JTextField();
		txtSecLocation.setText("A");
		txtSecLocation.setColumns(10);
		
		txtFirstLocation = new JTextField();
		txtFirstLocation.setText("A");
		txtFirstLocation.setColumns(10);
		
		final JTextArea txtResponse = new JTextArea();
		
		JLabel label_5 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05D0\u05EA\u05E8 : ");
		
		JLabel label_6 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05D0\u05EA\u05E8 \u05DE\u05E9\u05E0\u05D9 : ");
		
		JButton button = new JButton("\u05E6\u05D5\u05E8 \u05DE\u05E9\u05EA\u05DE\u05E9 \u05D7\u05D3\u05E9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ClientNum = txtClientNum.getText();
				String LicenseNum = txtLicenseNum.getText();
				String ALocation = txtFirstLocation.getText();
				String BLocation = txtSecLocation.getText();
				System.out.println(ClientNum.length());
				System.out.println(LicenseNum.length());
				System.out.println(ALocation.length());
				System.out.println(BLocation.length());
				if(ClientNum.length()!=5){
					txtResponse.append("שגיאה במספר לקוח \n");
					txtResponse.update(txtResponse.getGraphics());
					return;
				}
				if(LicenseNum.length()!=5){
					txtResponse.append("שגיאה במספר רישיון \n");
					txtResponse.update(txtResponse.getGraphics());
					return;
				}
				if(ALocation.length()!=1){
					txtResponse.append("שגיאה במספר אתר \n");
					txtResponse.update(txtResponse.getGraphics());
					return;
				}
				if(BLocation.length()!=1){
					txtResponse.append("שגיאה במספר אתר משני \n");
					txtResponse.update(txtResponse.getGraphics());
					return;
				}
				txtUserName.setText("L" + ClientNum + ALocation.toUpperCase() + "T" + LicenseNum + BLocation.toUpperCase());
				txtUserName.update(getGraphics());
				txtPassword.setText("t" + LicenseNum + "!");
				txtPassword.update(getGraphics());
				txtPath.setText("\\ftpusers\\" + ClientNum + ALocation.toUpperCase() + "\\" + LicenseNum + BLocation.toUpperCase() + "\\");
				txtPath.update(getGraphics());
				String response = null;
				if (JOptionPane.showConfirmDialog(null, "האם עברת על הנתונים?", "בדיקה", 
					    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
					    == JOptionPane.YES_OPTION)
					{
					try {
						response = Gui.Create("L" + ClientNum + ALocation.toUpperCase() + "T" + LicenseNum + BLocation.toUpperCase(), "t" + LicenseNum + "!","\\ftpusers\\" +
						ClientNum + ALocation + "\\" + LicenseNum + BLocation + "\\");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					else
					{
						return;
					}
				txtResponse.setText("");
				int a = 0;
				String b = null;
				b = response.substring(0,response.indexOf(">",a+1)+1);
				txtResponse.append(b + "\n");
				System.out.println(response.indexOf(">", a+1));
				while(response.indexOf(">", a+1) > 0){
					a = response.indexOf(">", a+1);
					if(a < response.length()-1 && a > 0){
						b = response.substring(a+1,response.indexOf(">",a+1));
					}else{
						b = response.substring(a,response.length());
					}
					txtResponse.append(b + "\n");
					txtResponse.update(txtResponse.getGraphics());
				};		
			}
		});
		
		JLabel label_7 = new JLabel("\u05EA\u05E9\u05D5\u05D1\u05EA \u05D4\u05E9\u05E8\u05EA :");
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(363, Short.MAX_VALUE)
							.addComponent(label_7))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
								.addComponent(txtResponse, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txtSecLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtFirstLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_5)
												.addComponent(label_6))
											.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtLicenseNum, Alignment.TRAILING)
												.addComponent(txtClientNum, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtPath, Alignment.TRAILING)
											.addComponent(txtPassword, Alignment.TRAILING)
											.addComponent(txtUserName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label, Alignment.TRAILING)
										.addComponent(label_1, Alignment.TRAILING)
										.addComponent(label_2, Alignment.TRAILING)
										.addComponent(label_3, Alignment.TRAILING)
										.addComponent(label_4, Alignment.TRAILING))))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(txtClientNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFirstLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_1)
							.addComponent(txtLicenseNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtSecLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_6))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(txtPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(label_7)
					.addGap(17)
					.addComponent(txtResponse, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(button)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	public static String Create(String User , String Password , String path) throws Exception{
		System.out.println("User is : " + User);
		System.out.println("Password is : " + Password);
		System.out.println("path is : " + path);
		String request = "<packet>" +
							"<ftp-user>" + 
									"<add>" +
										"<name>" + User +"</name>" + 
										"<password>" + Password + "</password>"+
										"<home>" + path + "</home>"+
										"<create-non-existent>true</create-non-existent>"+
										"<permissions>"+
											"<read>true</read>"+
											"<write>true</write>"+
										"</permissions>"+
										"<webspace-name>terem.co.il</webspace-name>"+
									"</add>"+
							"</ftp-user>" + 
						"</packet>";
		//login
		String login = "/*Enter Plesk username*/";
		String password = "/*Enter Plesk Password*/";
		String host = ("/*Enter Plesk domain (without http!!! it should look like plesk2.domain.co.il)*/");
		PleskApiClient client = new PleskApiClient(host);
		client.setCredentials(login, password);
		String response = client.request(request);
		System.out.println(response);
		request = "<packet>" +
				"<ftp-user>" + 
						"<set>" +
							"<filter>" + 
								"<name>" + User + "</name>"+
							"</filter>" +
							"<values>" +
								"<home>" +  path + "FROMLP\\TUPAL\\" + "</home>" + 
								"<create-non-existent>true</create-non-existent>"+
							"</values>"+
							"<webspace-name>terem.co.il</webspace-name>"+
						"</set>"+
				"</ftp-user>" + 
			"</packet>";
		response = client.request(request);
		System.out.println(response);
		request = "<packet>" +
				"<ftp-user>" + 
						"<set>" +
							"<filter>" + 
								"<name>" + User + "</name>"+
							"</filter>" +
							"<values>" +
								"<home>" +  path + "FROMHZ\\TUPAL\\" + "</home>" + 
								"<create-non-existent>true</create-non-existent>"+
							"</values>"+
							"<webspace-name>terem.co.il</webspace-name>"+
						"</set>"+
				"</ftp-user>" + 
			"</packet>";
		response = client.request(request);
		System.out.println(response);
		request = "<packet>" +
				"<ftp-user>" + 
						"<set>" +
							"<filter>" + 
								"<name>" + User + "</name>"+
							"</filter>" +
							"<values>" +
								"<home>" +  path + "</home>" + 
								"<create-non-existent>true</create-non-existent>"+
							"</values>"+
							"<webspace-name>terem.co.il</webspace-name>"+
						"</set>"+
				"</ftp-user>" + 
			"</packet>";
		response = client.request(request);
		System.out.println(response);
		return response;
		//return request;
	}
}
