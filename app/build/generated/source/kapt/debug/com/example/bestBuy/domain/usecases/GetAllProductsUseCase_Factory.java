package com.example.bestBuy.domain.usecases;

import com.example.bestBuy.domain.repository.ProductsRepository;
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
public final class GetAllProductsUseCase_Factory implements Factory<GetAllProductsUseCase> {
  private final Provider<ProductsRepository> productsRepoProvider;

  public GetAllProductsUseCase_Factory(Provider<ProductsRepository> productsRepoProvider) {
    this.productsRepoProvider = productsRepoProvider;
  }

  @Override
  public GetAllProductsUseCase get() {
    return newInstance(productsRepoProvider.get());
  }

  public static GetAllProductsUseCase_Factory create(
      Provider<ProductsRepository> productsRepoProvider) {
    return new GetAllProductsUseCase_Factory(productsRepoProvider);
  }

  public static GetAllProductsUseCase newInstance(ProductsRepository productsRepo) {
    return new GetAllProductsUseCase(productsRepo);
  }
}
