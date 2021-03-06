package com.ratebeer.android.api;

import com.ratebeer.android.api.model.BarcodeSearchResult;
import com.ratebeer.android.api.model.BeerAliasId;
import com.ratebeer.android.api.model.BeerDetails;
import com.ratebeer.android.api.model.BeerOnTopList;
import com.ratebeer.android.api.model.BeerRating;
import com.ratebeer.android.api.model.BeerSearchResult;
import com.ratebeer.android.api.model.BreweryBeer;
import com.ratebeer.android.api.model.BreweryDetails;
import com.ratebeer.android.api.model.BrewerySearchResult;
import com.ratebeer.android.api.model.CountryInfo;
import com.ratebeer.android.api.model.FeedItem;
import com.ratebeer.android.api.model.PlaceCheckinResult;
import com.ratebeer.android.api.model.PlaceDetails;
import com.ratebeer.android.api.model.PlaceNearby;
import com.ratebeer.android.api.model.PlaceSearchResult;
import com.ratebeer.android.api.model.StateInfo;
import com.ratebeer.android.api.model.StyleInfo;
import com.ratebeer.android.api.model.UserInfo;
import com.ratebeer.android.api.model.UserRateCount;
import com.ratebeer.android.api.model.UserRating;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

interface Routes {

	@FormUrlEncoded
	@POST("/Signin_r.asp")
	Observable<Response<Void>> login(@Field("username") String username, @Field("pwd") String password, @Field("SaveInfo") String assignCookie);

	@GET("/Signout.asp?v=1")
	Observable<Response<Void>> logout();

	@GET("users.asp")
	Observable<List<UserInfo>> getUserInfo(@Query("k") String key, @Query("u") String userName);

	@GET("feed.asp")
	Observable<List<FeedItem>> getFeed(@Query("k") String key, @Query("m") int mode);

	@GET("rc.asp")
	Observable<List<UserRateCount>> getUserRateCount(@Query("k") String key, @Query("uid") int userId);

	@GET("revs.asp?m=BR&x=2&x2=1")
	Observable<List<UserRating>> getUserRatings(@Query("k") String key, @Query("p") int page);

	@GET("s.asp")
	Observable<List<BeerSearchResult>> searchBeers(@Query("k") String key, @Query("u") Integer userId, @Query("b") String query);

	@GET("upc.asp")
	Observable<List<BarcodeSearchResult>> searchByBarcode(@Query("k") String key, @Query("upc") String barcode);

	@GET("bff.asp?vg=1&sid=1&cid=1&rc=1")
	Observable<List<BeerDetails>> getBeerDetails(@Query("k") String key, @Query("bd") int beerId);

	@GET("gr.asp")
	Observable<List<BeerRating>> getBeerRatings(@Query("k") String key, @Query("bid") int beerId, @Query("uid") Integer userId, @Query("p") int page,
												@Query("s") int sortOrder);

	// NOTE This is an html page, parsed manually via the HtmlConverterFactory
	@GET("/beer/alias/{beerId}/")
	Observable<BeerAliasId> getBeerAlias(@Path("beerId") int beerId);

	@FormUrlEncoded
	@POST("/saverating.asp")
	Observable<Response<Void>> postRating(@Field("BeerId") int beerId, @Field("aroma") int aroma, @Field("appearance") int appearance,
										  @Field("flavor") int flavor, @Field("palate") int palate, @Field("overall") int overall,
										  @Field(value = "Comments", encoded = true) String comments);

	@FormUrlEncoded
	@POST("/updaterating.asp")
	Observable<Response<Void>> updateRating(@Field("BeerId") int beerId, @Field("RatingId") int ratingId, @Field("aroma") int aroma,
											@Field("appearance") int appearance, @Field("flavor") int flavor, @Field("palate") int palate,
											@Field("overall") int overall, @Field(value = "Comments", encoded = true) String comments);

	@GET("bss.asp")
	Observable<List<BrewerySearchResult>> searchBreweries(@Query("k") String key, @Query("bn") String query);

	@GET("bi.asp")
	Observable<List<BreweryDetails>> getBreweryDetails(@Query("k") String key, @Query("b") int breweryId);

	@GET("bw.asp")
	Observable<List<BreweryBeer>> getBreweryBeers(@Query("k") String key, @Query("b") int breweryId, @Query("u") Integer userId);

	@GET("psstring.asp")
	Observable<List<PlaceSearchResult>> searchPlaces(@Query("k") String key, @Query("s") String query);

	@GET("beerme.asp")
	Observable<List<PlaceNearby>> getPlacesNearby(@Query("k") String key, @Query("mi") int radius, @Query("la") double latitude,
												  @Query("lo") double longitude);

	@GET("pss.asp")
	Observable<List<PlaceDetails>> getPlaceDetails(@Query("k") String key, @Query("pid") int placeId);

	@GET("ci.asp?t=Log")
	Observable<PlaceCheckinResult> performCheckin(@Query("k") String key, @Query("p") int placeId);

	@GET("tb.asp?m=top50")
	Observable<List<BeerOnTopList>> getTopOverall(@Query("k") String key);

	@GET("tb.asp?m=country")
	Observable<List<BeerOnTopList>> getTopByCountry(@Query("k") String key, @Query("c") int countryId);

	@GET("style.asp")
	Observable<List<BeerOnTopList>> getTopByStyle(@Query("k") String key, @Query("s") int styleId);

	@GET("country.asp")
	Observable<List<CountryInfo>> getCountries(@Query("k") String key);

	@GET("states.asp")
	Observable<List<StateInfo>> getStates(@Query("k") String key);

	@GET("styles.asp")
	Observable<List<StyleInfo>> getStyles(@Query("k") String key);

}
