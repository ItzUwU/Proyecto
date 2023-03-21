package scEntities;

public class scUsuario {
    
	private String scUsuario;
    private String scContrasena;
    
    public scUsuario(){
        
    }

    public scUsuario(String scUsuario, String scContrasena){
    	this.scUsuario = scUsuario;
        this.scContrasena = scContrasena;
    }

    public String getScUsuario() {
		return scUsuario;
	}

	public void setScUsuario(String usuario) {
		scUsuario = usuario;
	}

	public String getScContrasena() {
		return scContrasena;
	}

	public void setScContrasena(String contrasena) {
		scContrasena = contrasena;
	}

}
