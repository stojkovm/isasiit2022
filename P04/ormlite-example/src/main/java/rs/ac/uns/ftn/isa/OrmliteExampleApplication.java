package rs.ac.uns.ftn.isa;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import com.j256.ormlite.jdbc.DataSourceConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import rs.ac.uns.ftn.isa.domain.Greeting;

@SpringBootApplication
public class OrmliteExampleApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(OrmliteExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrmliteExampleApplication.class, args);
		initDB();
	}
	
	@Bean
    public static DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:greetingsdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
	
	@Bean
	public static DataSourceConnectionSource getConnectionSource() {
		DataSourceConnectionSource cs = null;
		try {
			cs = new DataSourceConnectionSource(getDataSource(), "jdbc:h2:mem:greetingsdb");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Application failed at creating database connection.", e);
		}
		return cs;
	}
	
	public static void initDB() {
		try {
			TableUtils.createTableIfNotExists((ConnectionSource)getConnectionSource(), Greeting.class);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Application failed at creating database table(s).", e);
		}
	}

}
