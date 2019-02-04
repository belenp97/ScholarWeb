package es.urjc.etsii.dad.scholarWeb;

public class Contacto {

	private String nombre;
	private String asunto;
	private String cuerpo;


	public Contacto() {

	}

	public Contacto(String nombre, String asunto, String cuerpo) {
		super();
		this.nombre = nombre;
		this.asunto = asunto; 
		this.cuerpo = cuerpo;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String getasunto() {
		return asunto;
	}

	public void setasunto(String asunto) {
		this.asunto = asunto;
	}
	
	public String getcuerpo() {
		return cuerpo;
	}

	public void setcuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Override
	public String toString() {
		return "Anuncio [nombre=" + nombre +" asunto= " +asunto + ", cuerpo=" + cuerpo + "]";
	}

}
