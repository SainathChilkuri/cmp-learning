package com.get.set.coremodule

suspend inline fun <P,S, reified E: Exception,U: BaseUseCase<S, P>> executeUseCase(
    onSuccess: (s: S) -> Unit,
    onError: (e: E) -> Unit,
    useCase: U,
    params: P
) {
    try{
        val result: S = useCase.execute(params);
        onSuccess(result);
    }catch(e: AppCustomException) {
       if(e is E) {
           onError(e)
       }
    } catch (e: Exception) {
        if(e is E) {
            onError(e)
        }
    }
}