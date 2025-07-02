package com.example.takeALot.data.repository;

import com.example.takeALot.data.remote.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class ProductsRepositoryImpl_Factory implements Factory<ProductsRepositoryImpl> {
  private final Provider<ApiService> productsApiProvider;

  public ProductsRepositoryImpl_Factory(Provider<ApiService> productsApiProvider) {
    this.productsApiProvider = productsApiProvider;
  }

  @Override
  public ProductsRepositoryImpl get() {
    return newInstance(productsApiProvider.get());
  }

  public static ProductsRepositoryImpl_Factory create(Provider<ApiService> productsApiProvider) {
    return new ProductsRepositoryImpl_Factory(productsApiProvider);
  }

  public static ProductsRepositoryImpl newInstance(ApiService productsApi) {
    return new ProductsRepositoryImpl(productsApi);
  }
}
