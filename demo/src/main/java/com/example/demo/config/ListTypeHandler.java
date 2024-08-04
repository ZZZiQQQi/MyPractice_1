package com.example.demo.config;
import com.example.demo.entity.LineDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.util.List;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
@Slf4j
public class ListTypeHandler extends BaseTypeHandler<List<LineDetails>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<LineDetails> parameter, JdbcType jdbcType) throws SQLException {
        log.info("序列化进行中");
        ps.setString(i, toJson(parameter));
    }

    @Override
    public List<LineDetails> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toObject(rs.getString(columnName));
    }

    @Override
    public List<LineDetails> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toObject(rs.getString(columnIndex));
    }

    @Override
    public List<LineDetails> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toObject(cs.getString(columnIndex));
    }

    private String toJson(List<LineDetails> object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert object to JSON string", e);
        }
    }

    private List<LineDetails> toObject(String content) {
        if (content == null || content.isEmpty()) {
            return null;
        }
        try {
            return objectMapper.readValue(content, new TypeReference<List<LineDetails>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON string to object", e);
        }
    }
}
