package org.rapidoid.jpa;

import org.hibernate.jpa.boot.spi.PersistenceUnitDescriptor;
import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.PersistenceUnitTransactionType;
import java.net.URL;
import java.util.List;
import java.util.Properties;

@Authors("Nikolche Mihajlovski")
@Since("5.1.0")
public class CustomDescriptor implements PersistenceUnitDescriptor {

	private final PersistenceUnitDescriptor descriptor;

	private final List<String> names;

	public CustomDescriptor(PersistenceUnitDescriptor descriptor, List<String> names) {
		this.descriptor = descriptor;
		this.names = names;
		this.names.addAll(descriptor.getManagedClassNames());
	}

	@Override
	public URL getPersistenceUnitRootUrl() {
		return descriptor.getPersistenceUnitRootUrl();
	}

	@Override
	public String getName() {
		return descriptor.getName();
	}

	@Override
	public String getProviderClassName() {
		return descriptor.getProviderClassName();
	}

	@Override
	public boolean isUseQuotedIdentifiers() {
		return descriptor.isUseQuotedIdentifiers();
	}

	@Override
	public boolean isExcludeUnlistedClasses() {
		return descriptor.isExcludeUnlistedClasses();
	}

	@Override
	public PersistenceUnitTransactionType getTransactionType() {
		return descriptor.getTransactionType();
	}

	@Override
	public ValidationMode getValidationMode() {
		return descriptor.getValidationMode();
	}

	@Override
	public SharedCacheMode getSharedCacheMode() {
		return descriptor.getSharedCacheMode();
	}

	@Override
	public List<String> getManagedClassNames() {
		return names;
	}

	@Override
	public List<String> getMappingFileNames() {
		return descriptor.getMappingFileNames();
	}

	@Override
	public List<URL> getJarFileUrls() {
		return descriptor.getJarFileUrls();
	}

	@Override
	public Object getNonJtaDataSource() {
		return descriptor.getNonJtaDataSource();
	}

	@Override
	public Object getJtaDataSource() {
		return descriptor.getJtaDataSource();
	}

	@Override
	public Properties getProperties() {
		return descriptor.getProperties();
	}

	@Override
	public ClassLoader getClassLoader() {
		return descriptor.getClassLoader();
	}

	@Override
	public void pushClassTransformer(List<String> entityClassNames) {
		descriptor.pushClassTransformer(entityClassNames);
	}
}
