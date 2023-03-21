package scDataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import scEntities.scUsuario;

public class scDACUsuario extends scDataHelper {
    PreparedStatement ps;
    ResultSet rs;
    public scUsuario scLogin (String user) {
		scUsuario usuario = new scUsuario();
		String sql = "SELECT * FROM SCLOGIN WHERE SCUSUARIO = ?";
		try {
			ps = scDataHelper.scGetConexion().prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
				if (rs.next()) {
					usuario.setScContrasena(rs.getString("SCCONTRASENA"));
					usuario.setScUsuario(rs.getString("SCUSUARIO"));
				}
				scDataHelper.scCerrarConexion();
		} catch ( SQLException e) {
			System.out.println(e.toString());
		}
		return usuario;
	}
}
