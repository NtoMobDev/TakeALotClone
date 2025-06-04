package com.example.bestBuy.presentation.viewmodel;

import com.example.bestBuy.domain.usecases.GetAllProductsUseCase;
import com.example.bestBuy.domain.usecases.GetHomePageProductsUseCase;
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
public final class ProductsViewModel_Factory implements Factory<ProductsViewModel> {
  private final Provider<GetAllProductsUseCase> getProductsProvider;

  private final Provider<GetHomePageProductsUseCase> getHomePageProductsUseCaseProvider;

  public ProductsViewModel_Factory(Provider<GetAllProductsUseCase> getProductsProvider,
      Provider<GetHomePageProductsUseCase> getHomePageProductsUseCaseProvider) {
    this.getProductsProvider = getProductsProvider;
    this.getHomePageProductsUseCaseProvider = getHomePageProductsUseCaseProvider;
  }

  @Override
  public ProductsViewModel get() {
    return newInstance(getProductsProvider.get(), getHomePageProductsUseCaseProvider.get());
  }

  public static ProductsViewModel_Factory create(
      Provider<GetAllProductsUseCase> getProductsProvider,
      Provider<GetHomePageProductsUseCase> getHomePageProductsUseCaseProvider) {
    return new ProductsViewModel_Factory(getProductsProvider, getHomePageProductsUseCaseProvider);
  }

  public static ProductsViewModel newInstance(GetAllProductsUseCase getProducts,
      GetHomePageProductsUseCase getHomePageProductsUseCase) {
    return new ProductsViewModel(getProducts, getHomePageProductsUseCase);
  }
}
