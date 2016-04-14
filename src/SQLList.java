import java.util.*;
public class SQLList {
	ArrayList<String> sql = null;

	public SQLList(){
		sql = new ArrayList<String>();
		sql.add("SELECT id,identifier FROM pokemon WHERE id=?");//Return the selected pokemon
		sql.add("SELECT base_stat FROM pokemon INNER JOIN pokemonStats ON pokemon.id = pokemonStats.pokemon_id WHERE id= ? ORDER BY stat_id");//Return selected pokemon stats
		sql.add("SELECT Types.type_identifier FROM pokemon INNER JOIN pokemonTypes ON pokemon.id = pokemonTypes.pokemon_id INNER JOIN Types ON pokemonTypes.type_id = Types.id WHERE pokemon.id = ?");//Return selected pokemon type
		sql.add("SELECT moves.move_identifier, moves.power, types.type_identifier, pokemonMoves2.level, moveDamageClasses.damage_class_identifier FROM pokemon INNER JOIN pokemonMoves2 ON pokemon.id = pokemonMoves2.pokemon_id INNER JOIN moves ON pokemonMoves2.move_id = moves.move_id INNER JOIN types ON moves.type_id = types.id INNER JOIN moveDamageClasses ON moves.damage_class_id = moveDamageClasses.id WHERE pokemon.id = ? AND pokemonMoves2.pokemon_move_method_id = 1 AND pokemonMoves2.version_group_id = 15 ORDER BY pokemonMoves2.level ASC, moves.move_identifier ASC");//Selected Pokemon moves
	}

	public String returnSQL(int i)
	{
		int index = i;
		return sql.get(index);
	}
}
