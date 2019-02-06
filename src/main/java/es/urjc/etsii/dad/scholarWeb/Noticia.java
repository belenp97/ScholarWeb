package es.urjc.etsii.dad.scholarWeb;

public class Noticia {

	private String titulo;
	private String cuerpo;

	public Noticia() {

	}

	public Noticia(String titulo, String cuerpo) {
		super();
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}

	public String gettitulo() {
		return titulo;
	}

	public void settitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getcuerpo() {
		return cuerpo;
	}

	public void setcuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Override
	public String toString() {
		return "Anuncio [titulo=" + titulo + ", cuerpo=" + cuerpo + "]";
	}
}