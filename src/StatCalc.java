
public class StatCalc {
	
	
	float colorValue = 0.0f;
	float temp = 0.0f;
	
	
	public StatCalc()
	{

	}
	
	public float colorCalc(float s)
	{
		float stat = s;
		temp = (stat * 170.0f);
		temp = (temp/255.0f);
		temp = (temp * (0.472f));
		colorValue = (temp/170.0f);
		return colorValue;
	}

}
