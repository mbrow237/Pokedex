import java.sql.*;
import java.util.*;
import javax.swing.*;
public class sqliteConnection {
	//public static Connection dbConnect()
	Connection c = null;
	public sqliteConnection(){
		try{
			Class.forName("org.sqlite.JDBC");	
		}catch(Exception e)
		{
			System.out.println(e);
		}
			try{
				c =  DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Melvin\\Desktop\\Programming\\Workstation\\pokedb.db");
			}
			catch(SQLException e){
				System.out.println("Error" + e);
			}
	}	
	
	public ResultSet selectedPokemon()//List of all the pokemon to put into the combobox
	{	
		ResultSet rs = null;
		try{
		String sql = "SELECT id,identifier FROM pokemon";
		Statement stmt = c.createStatement();
		rs = stmt.executeQuery(sql);
		}
		catch(SQLException e){
			System.out.println("Error" + e);
		}		
		return rs;
	}
	
	public ResultSet selectedPokemon(String s, int i)//Return the selected pokemon
	{	
		ResultSet rs = null;
		int index = i;
		try{
		String sql = s;
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,index);
		rs = ps.executeQuery();
		}
		catch(SQLException e){
			System.out.println("Error" + e);
		}		
		return rs;
	}
	/*
	public ResultSet selectedPokemonStats(int i)//Return the selected pokemon's stats
	{	
		ResultSet rs = null;
		int index = i;
		try{
		String sql = "SELECT stat_id, base_stat FROM pokemon INNER JOIN pokemonStats ON pokemon.id = pokemonStats.pokemon_id WHERE id=?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,index);
		rs = ps.executeQuery();
		}
		catch(SQLException e){
			System.out.println("Error" + e);
		}		
		return rs;
	}
	
	public ResultSet selectedPokemonType(int i)
	{
		ResultSet rs = null;
		int index = i;
		try{
		String sql = "SELECT Types.type_identifier FROM pokemon INNER JOIN pokemonTypes ON pokemon.id = pokemonTypes.pokemon_id INNER JOIN Types ON pokemonTypes.type_id = Types.id WHERE pokemon.id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,index);
		rs = ps.executeQuery();
		}
		catch(SQLException e){
			System.out.println("Error" + e);
		}		
		return rs;
	}
	*/
	public ResultSet selectedPokemonAbility(int i, int j)
	{
		ResultSet rs = null;
		int index = i;
		int isHidden = j;
		try{
		String sql = "SELECT abilities.identifier FROM pokemon INNER JOIN pokemonAbilities ON pokemon.id = pokemonAbilities.pokemon_id INNER JOIN abilities ON pokemonAbilities.ability_id = abilities.id WHERE pokemon.id = ? and pokemonAbilities.is_hidden = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1,index);
		ps.setInt(2,isHidden);
		rs = ps.executeQuery();
		}
		catch(SQLException e){
			System.out.println("Error" + e);
		}		
		return rs;
	}
}