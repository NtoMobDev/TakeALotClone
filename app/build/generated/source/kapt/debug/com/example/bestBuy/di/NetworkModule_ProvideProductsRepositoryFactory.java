package com.example.bestBuy.di;

import com.example.bestBuy.data.remote.ApiService;
import com.example.bestBuy.domain.repository.ProductsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NetworkModule_ProvideProductsRepositoryFactory implements Factory<ProductsRepository> {
  private final Provider<ApiService> apiServiceProvider;

  public NetworkModule_ProvideProductsRepositoryFactory(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public ProductsRepository get() {
    return provideProductsRepository(apiServiceProvider.get());
  }

  public static NetworkModule_ProvideProductsRepositoryFactory create(
      Provider<ApiService> apiServiceProvider) {
    return new NetworkModule_ProvideProductsRepositoryFactory(apiServiceProvider);
  }

  public static ProductsRepository provideProductsRepository(ApiService apiService) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideProductsRepository(apiService));
  }
}
