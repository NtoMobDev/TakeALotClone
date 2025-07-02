package com.example.takeALot.domain.usecases;

import com.example.takeALot.domain.repository.ProductsRepository;
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
public final class GetSingleProductUseCase_Factory implements Factory<GetSingleProductUseCase> {
  private final Provider<ProductsRepository> productsRepoProvider;

  public GetSingleProductUseCase_Factory(Provider<ProductsRepository> productsRepoProvider) {
    this.productsRepoProvider = productsRepoProvider;
  }

  @Override
  public GetSingleProductUseCase get() {
    return newInstance(productsRepoProvider.get());
  }

  public static GetSingleProductUseCase_Factory create(
      Provider<ProductsRepository> productsRepoProvider) {
    return new GetSingleProductUseCase_Factory(productsRepoProvider);
  }

  public static GetSingleProductUseCase newInstance(ProductsRepository productsRepo) {
    return new GetSingleProductUseCase(productsRepo);
  }
}
