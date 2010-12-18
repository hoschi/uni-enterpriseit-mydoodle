/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uniluebeck.itm.ep5.util;

import antlr.StringUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author hoschi
 */
public class UuidGenerator  implements IdentifierGenerator {

	public Serializable generate(SessionImplementor session, Object object) {
		return UUID.randomUUID().toString();
	}
}
