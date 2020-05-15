package com.vladmihalcea.hibernate.type.search;

import com.vladmihalcea.hibernate.type.AbstractHibernateType;
import com.vladmihalcea.hibernate.type.search.internal.PostgreSQLTSVectorSqlTypeDescriptor;
import com.vladmihalcea.hibernate.type.search.internal.PostgreSQLTSVectorTypeDescriptor;
import com.vladmihalcea.hibernate.type.util.Configuration;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.usertype.DynamicParameterizedType;

import java.util.Properties;

/**
 * Maps a {@link String} object type to a PostgreSQL TSVector column type.
 *
 * @author Vlad Mihalcea
 * @author Philip Riecks
 */
public class PostgreSQLTSVectorType
        extends AbstractHibernateType<Object> implements DynamicParameterizedType {

    public static final PostgreSQLTSVectorType INSTANCE = new PostgreSQLTSVectorType();


    public PostgreSQLTSVectorType() {
        super(
            PostgreSQLTSVectorSqlTypeDescriptor.INSTANCE,
            new PostgreSQLTSVectorTypeDescriptor()
        );
    }

    public PostgreSQLTSVectorType(org.hibernate.type.TypeFactory typeBootstrapContext) {
        super(
            PostgreSQLTSVectorSqlTypeDescriptor.INSTANCE,
            new PostgreSQLTSVectorTypeDescriptor(),
            new Configuration(typeBootstrapContext.getConfigurationSettings())
        );
    }

    @Override
    public String getName() {
        return "tsvector";
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ((PostgreSQLTSVectorTypeDescriptor) getJavaTypeDescriptor()).setParameterValues(parameters);
    }
}
