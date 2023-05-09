package ohm.softa.a08.services;

import ohm.softa.a08.api.OpenMensaAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenMensaApiService {

	private static OpenMensaApiService instance;
	private OpenMensaAPI apiInstance;

	private OpenMensaApiService() {
	}

	public static OpenMensaApiService getInstance() {
		if (instance == null) {
			instance = new OpenMensaApiService();

		}
		return instance;
	}

	public OpenMensaAPI getApi() {
		if (this.apiInstance == null) {
			Retrofit retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.baseUrl("https://openmensa.org/api/v2/")
				.build();
			instance.apiInstance = retrofit.create(OpenMensaAPI.class);
		}
		return apiInstance;
	}
}
