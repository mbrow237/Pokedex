
import java.sql.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;



public class MainGUI extends JFrame implements ActionListener {
	private ResultSet rs = null;
	private ResultSet selectedPokemon = null;
	private sqliteConnection sqlConn = new sqliteConnection();
	private SQLList sql = new SQLList();
	private JPanel contentPane;
	private JLabel pokemonIDLabel = new JLabel("dummy");
	private JLabel pokemonNameLabel = new JLabel("dummy");
	private final JLabel idConst = new JLabel("ID");
	private final JLabel nameConst = new JLabel("Name");
	private final JLabel lblTypeConst = new JLabel("Type");
	private final JLabel lblTypeOne = new JLabel("Type 1");
	private final JLabel lblTypeTwo = new JLabel("Type 2");
	private final JLabel lblAbilityOne = new JLabel("Ability 1");
	private final JLabel lblAbilityTwo = new JLabel("Ability 2");
	private final JLabel lblHiddenAbilityOne = new JLabel("Hidden Ability 1");
	private final JLabel lblHpstat = new JLabel("HpStat");
	private final JLabel lblAtkstat = new JLabel("AtkStat");
	private final JLabel lblDefstat = new JLabel("DefStat");
	private final JLabel lblSpatkstat = new JLabel("SpAtkStat");
	private final JLabel lblSpdefstat = new JLabel("SpDefStat");
	private final JLabel lblSpeedstat = new JLabel("SpeedStat");
	private final JLabel lblBststat = new JLabel("BSTStat");
	
	private JTable movesTable;
	private JScrollPane movesTablescrollPane;
	public JPanel DrawingPanel;
	public RectDraw newrect= new RectDraw();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(5, 5, 620, 20);
		comboBox.addActionListener(this);
		contentPane.setLayout(null);
		
		contentPane.add(comboBox);
		
		
		pokemonIDLabel.setBounds(5, 65, 26, 14);
		contentPane.add(pokemonIDLabel);
		

		pokemonNameLabel.setBounds(39, 65, 115, 14);
		contentPane.add(pokemonNameLabel);
		idConst.setBounds(5, 36, 26, 14);
		
		contentPane.add(idConst);
		nameConst.setBounds(39, 36, 46, 14);
		
		contentPane.add(nameConst);
		lblTypeConst.setBounds(145, 36, 46, 14);
		
		contentPane.add(lblTypeConst);
		lblTypeOne.setBounds(145, 65, 46, 14);
		
		contentPane.add(lblTypeOne);
		lblTypeTwo.setBounds(201, 65, 46, 14);
		
		contentPane.add(lblTypeTwo);
		
		JLabel lblAbilityConst = new JLabel("Ability");
		lblAbilityConst.setBounds(282, 36, 46, 14);
		contentPane.add(lblAbilityConst);
		
		
		lblAbilityOne.setBounds(282, 65, 84, 14);
		contentPane.add(lblAbilityOne);
		
		
		lblAbilityTwo.setBounds(369, 65, 84, 14);
		contentPane.add(lblAbilityTwo);
		
		JLabel lblHiddenAbilityConst = new JLabel("Hidden Ability");
		lblHiddenAbilityConst.setBounds(483, 36, 84, 14);
		contentPane.add(lblHiddenAbilityConst);
		
		
		lblHiddenAbilityOne.setBounds(483, 65, 115, 14);
		contentPane.add(lblHiddenAbilityOne);
		
		movesTablescrollPane = new JScrollPane();
		movesTablescrollPane.setBounds(5, 235, 698, 213);
		contentPane.add(movesTablescrollPane);
		
		JLabel lblHp = new JLabel("Hp");
		lblHp.setBounds(39, 89, 23, 14);
		contentPane.add(lblHp);
		
		JLabel lblDef = new JLabel("Def");
		lblDef.setBounds(39, 115, 46, 14);
		contentPane.add(lblDef);
		
		JLabel lblAtk = new JLabel("Atk");
		lblAtk.setBounds(39, 102, 46, 14);
		contentPane.add(lblAtk);
		
		JLabel lblSpAtk = new JLabel("Sp Atk");
		lblSpAtk.setBounds(39, 128, 46, 14);
		contentPane.add(lblSpAtk);
		
		JLabel lblSpDef = new JLabel("Sp Def");
		lblSpDef.setBounds(39, 141, 46, 14);
		contentPane.add(lblSpDef);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(39, 154, 46, 14);
		contentPane.add(lblSpeed);
		
		JLabel lblBst = new JLabel("BST");
		lblBst.setBounds(39, 167, 46, 14);
		contentPane.add(lblBst);
		
		//JLabel lblHpstat = new JLabel("HpStat");
		lblHpstat.setBounds(91, 89, 46, 14);
		contentPane.add(lblHpstat);
		
		//JLabel lblAtkstat = new JLabel("AtkStat");
		lblAtkstat.setBounds(91, 102, 46, 14);
		contentPane.add(lblAtkstat);
		
		//JLabel lblDefstat = new JLabel("DefStat");
		lblDefstat.setBounds(91, 115, 46, 14);
		contentPane.add(lblDefstat);
		
		//JLabel lblSpatkstat = new JLabel("SpAtkStat");
		lblSpatkstat.setBounds(91, 128, 46, 14);
		contentPane.add(lblSpatkstat);
		
		//JLabel lblSpdef = new JLabel("SpDefStat");
		lblSpdefstat.setBounds(91, 141, 46, 14);
		contentPane.add(lblSpdefstat);
		
		//JLabel lblSpeedstat = new JLabel("SpeedStat");
		lblSpeedstat.setBounds(91, 154, 46, 14);
		contentPane.add(lblSpeedstat);
		
		//JLabel lblBststat = new JLabel("BSTStat");
		lblBststat.setBounds(91, 167, 46, 14);
		contentPane.add(lblBststat);
		
	DrawingPanel = new JPanel();
		DrawingPanel.setBounds(135, 89, 568, 137);
		contentPane.add(DrawingPanel);
		DrawingPanel.setLayout(new BorderLayout(0, 0));
		

		
		
		rs = sqlConn.selectedPokemon();
		try{
			while(rs.next()){
				int id = rs.getInt("id");
				String identifier = rs.getString("identifier");
				//String tempName = id+" "+identifier;
				comboBox.addItem(id+" "+identifier);
			}
		rs.close();
		}
			catch(SQLException e){
			System.out.println("Error" + e);
		}

	}

	public void actionPerformed(ActionEvent ev)
	{
		JComboBox cb = (JComboBox)ev.getSource();
		String pokeID = (String)cb.getSelectedItem();
		int i = pokeID.indexOf(' ');
		String word = pokeID.substring(0, i);
		int index = Integer.parseInt(word);
		displaySelectedPokemon(index);
		displaySelectedPokemonType(index);
		displaySelectedPokemonAbility(index);
		displaySelectedPokemonMoves(index);
		displaySelectedPokemonStats(index);
	}
	
	public void displaySelectedPokemon(int i)
	{
		int index = i;
		int id = 0;
		String identifier ="";
		selectedPokemon = sqlConn.selectedPokemon(sql.returnSQL(0),index);
		try{
			id = selectedPokemon.getInt("id");
			identifier = selectedPokemon.getString("identifier");
			selectedPokemon.close();
		}
		catch(SQLException e){
		System.out.println("Error" + e);
	}
		pokemonIDLabel.setText(id+"");
		pokemonNameLabel.setText(identifier);
	}

	public void displaySelectedPokemonType(int i)
	{
		int index = i;
		int count = 0;
		String typeOne = "";
		String typeTwo = "";
		selectedPokemon = sqlConn.selectedPokemon(sql.returnSQL(2),index);
		try{
			while(selectedPokemon.next()){
				count++;
				String identifier = selectedPokemon.getString("type_identifier");
                if (count == 1)
                {
                	typeOne = identifier;
                }
                else
                if (count == 2)
                {
                	typeTwo = identifier;
                }
			}
			selectedPokemon.close();
		}
			catch(SQLException e){
			System.out.println("Error" + e);
		}
		lblTypeOne.setText(typeOne);
		lblTypeTwo.setText(typeTwo);
	}
	public void displaySelectedPokemonAbility(int i)
	{
		int index = i;
		int count = 0;
		String abilityOne = "";
		String abilityTwo = "";
		String hiddenAbility = "";
		//find regular abilities
		selectedPokemon = sqlConn.selectedPokemonAbility(index,0);
		try{
			while(selectedPokemon.next()){
				count++;
				String identifier = selectedPokemon.getString("identifier");
                if (count == 1)
                {
                	abilityOne = identifier;
                }
                else
                if (count == 2)
                {
                	abilityTwo = identifier;
                }
			}
			selectedPokemon.close();
		}
			catch(SQLException e){
			System.out.println("Error" + e);
		}
		//Find Hidden Ability
		selectedPokemon = sqlConn.selectedPokemonAbility(index,1);
		try{
			while(selectedPokemon.next()){
				hiddenAbility = selectedPokemon.getString("identifier");
				selectedPokemon.close();
			}
		}
			catch(SQLException e){
			System.out.println("Error" + e);
		}
		lblAbilityOne.setText(abilityOne);
		lblAbilityTwo.setText(abilityTwo);
		lblHiddenAbilityOne.setText(hiddenAbility);
	}
	
	public void displaySelectedPokemonMoves(int i)
	{
		int index = i;
		int power = 0;
		int level = 0;
		String moves_identifier = "";
		String type_identifier = "";
		String damage_class_identifier = "";
		Vector<Vector> moveRows = new Vector<Vector>();
		Vector row = null;
		Vector columnName = new Vector();
		columnName.addElement(new String("Move"));
		columnName.addElement(new String("Power"));
		columnName.addElement(new String("Level Learned"));
		columnName.addElement(new String("Type"));
		columnName.addElement(new String("Damage Class"));
		selectedPokemon = sqlConn.selectedPokemon(sql.returnSQL(3),index);
		try{
			while(selectedPokemon.next()){
				moves_identifier = selectedPokemon.getString("move_identifier");
				power = selectedPokemon.getInt("power");
				level = selectedPokemon.getInt("level");
				type_identifier = selectedPokemon.getString("type_identifier");
				damage_class_identifier = selectedPokemon.getString("damage_class_identifier");
				row = new Vector();
				row.addElement(moves_identifier);
				row.addElement(power);
				row.addElement(level);
				row.addElement(type_identifier);
				row.addElement(damage_class_identifier);
				moveRows.addElement(row);
			}
			movesTable = new JTable(moveRows,columnName);
			movesTablescrollPane.setViewportView(movesTable);
		}catch(SQLException e){
			System.out.println("Error" + e);
		}
	}
	
	   public void paint(Graphics g) {     
		   g.fillRect (140,89,46,14);
		   }
	
	public void displaySelectedPokemonStats(int i)
	{
		int index = i;
		int hp = 0;
		int atk = 0;
		int def = 0;
		int spatk = 0;
		int spdef = 0;
		int speed = 0;
		int bst = 0;
		selectedPokemon = sqlConn.selectedPokemon(sql.returnSQL(1),index);
		try{
			while(selectedPokemon.next()){
				hp = selectedPokemon.getInt("base_stat");
				selectedPokemon.next();
				atk = selectedPokemon.getInt("base_stat");
				selectedPokemon.next();
				def = selectedPokemon.getInt("base_stat");
				selectedPokemon.next();
				spatk = selectedPokemon.getInt("base_stat");
				selectedPokemon.next();
				spdef = selectedPokemon.getInt("base_stat");
				selectedPokemon.next();
				speed = selectedPokemon.getInt("base_stat");
				//selectedPokemon.next();
			}
	}catch(SQLException e){
		System.out.println("Error" + e);
	}
		bst = (hp+atk+def+spatk+spdef+speed);
		lblHpstat.setText((String.valueOf(hp)));
		lblAtkstat.setText((String.valueOf(atk)));
		lblDefstat.setText((String.valueOf(def)));
		lblSpatkstat.setText((String.valueOf(spatk)));
		lblSpdefstat.setText((String.valueOf(spdef)));
		lblSpeedstat.setText((String.valueOf(speed)));
		lblBststat.setText((String.valueOf(bst)));
		newrect.setStats(hp,atk,def,spatk,spdef,speed);
		DrawingPanel.add(newrect);
}
}

class RectDraw extends JPanel {
	int hp = 0;
	int atk = 0;
	int def = 0;
	int spatk = 0;
	int spdef = 0;
	int speed = 0;
	static StatCalc s = new StatCalc();
	public void setStats(int h, int a, int d, int sa, int sd, int sp)
	{
		hp = h;
		atk = a;
		def = d;
		spatk = sa;
		spdef = sd;
		speed = sp;		
	}
	@Override
	 public void paintComponent(Graphics g) {
    super.paintComponent(g);  
     g.setColor(Color.getHSBColor(s.colorCalc((float)hp), 1.0f, 1.0f));
     g.fillRect (0, 0,hp,10);
     g.setColor(Color.getHSBColor(s.colorCalc((float)atk), 1.0f, 1.0f));
     g.fillRect(0, 13, atk, 10);
     g.setColor(Color.getHSBColor(s.colorCalc((float)def), 1.0f, 1.0f));
     g.fillRect(0, 26, def, 10);
     g.setColor(Color.getHSBColor(s.colorCalc((float)spatk), 1.0f, 1.0f));
     g.fillRect(0, 39, spatk, 10);
     g.setColor(Color.getHSBColor(s.colorCalc((float)spdef), 1.0f, 1.0f));
     g.fillRect(0, 52, spdef, 10);
     g.setColor(Color.getHSBColor(s.colorCalc((float)speed), 1.0f, 1.0f));
     g.fillRect(0, 65, speed, 10);
    }
    }


