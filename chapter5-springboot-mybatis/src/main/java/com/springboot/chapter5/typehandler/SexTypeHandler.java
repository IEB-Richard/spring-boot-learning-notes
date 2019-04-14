package com.springboot.chapter5.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import com.springboot.chapter5.enumeration.SexEnum;

// tell MyBatis what's the data type in MySQL 
@MappedJdbcTypes(JdbcType.INTEGER)
// Tell MyBatis what's the data type in Java
@MappedTypes(value=SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

	/**
	 * 设置非空性别参数
	 * 
	 * @param ps
	 * @param idx
	 * @param sex
	 * @param jdbcType
	 * @throws SQLException
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int idx, SexEnum sex, JdbcType jdbcType) throws SQLException {
		ps.setInt(idx, sex.getId());
	}

	/**
	 * 通过列名读取性别
	 * 
	 * @param rs
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	@Override
	public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {

		int sex = rs.getInt(columnName);
		if (sex != 1 && sex != 2) {
			return null;
		}
		return SexEnum.getEnumById(sex);
	}

	@Override
	public SexEnum getNullableResult(ResultSet rs, int idx) throws SQLException {
		int sex = rs.getInt(idx);
		if (sex != 1 && sex != 2) {
			return null;
		}
		return SexEnum.getEnumById(sex);
	}
	/**
	 * 通过存储过程读取性别
	 * @param cs
	 * @param columnIndex
	 * @return
	 * @throws SQLException
	 */
	@Override
	public SexEnum getNullableResult(CallableStatement cs, int idx) throws SQLException {
        int sex = cs.getInt(idx);
        if (sex != 1 && sex != 2) {
            return null;
        }
        return SexEnum.getEnumById(sex);
	}

}
