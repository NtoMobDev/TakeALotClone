package com.example.takeALot.presentation.viewmodel;

import androidx.lifecycle.SavedStateHandle;
import com.example.takeALot.domain.usecases.GetProductsByCategoryUseCase;
import com.example.takeALot.domain.usecases.GetSingleProductUseCase;
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
public final class SingleProductViewModel_Factory implements Factory<SingleProductViewModel> {
  private final Provider<GetSingleProductUseCase> getSingleProductUseCaseProvider;

  private final Provider<GetProductsByCategoryUseCase> getProductsByCategoryUseCaseProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public SingleProductViewModel_Factory(
      Provider<GetSingleProductUseCase> getSingleProductUseCaseProvider,
      Provider<GetProductsByCategoryUseCase> getProductsByCategoryUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getSingleProductUseCaseProvider = getSingleProductUseCaseProvider;
    this.getProductsByCategoryUseCaseProvider = getProductsByCategoryUseCaseProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public SingleProductViewModel get() {
    return newInstance(getSingleProductUseCaseProvider.get(), getProductsByCategoryUseCaseProvider.get(), savedStateHandleProvider.get());
  }

  public static SingleProductViewModel_Factory create(
      Provider<GetSingleProductUseCase> getSingleProductUseCaseProvider,
      Provider<GetProductsByCategoryUseCase> getProductsByCategoryUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new SingleProductViewModel_Factory(getSingleProductUseCaseProvider, getProductsByCategoryUseCaseProvider, savedStateHandleProvider);
  }

  public static SingleProductViewModel newInstance(GetSingleProductUseCase getSingleProductUseCase,
      GetProductsByCategoryUseCase getProductsByCategoryUseCase,
      SavedStateHandle savedStateHandle) {
    return new SingleProductViewModel(getSingleProductUseCase, getProductsByCategoryUseCase, savedStateHandle);
  }
}
