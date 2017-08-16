package test;

import dao.*;
import vo.*;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by user on 2017-08-09.
 */
public class TestDao {
    Account account1;
    Account accountChange;
    PetInfo pet1;
    Breed breed1;
    UserInfo userInfo;
    Location location;
    PlaceImg placeImg;
    Place place;

    @Before
    public void setUp(){

        DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");

        account1 = new Account();
        account1.setPk(1);
        account1.setEmail("apple");
        account1.setPassword("aaa");
        account1.setCount(0);
        account1.setAutholization(0);

        pet1 = new PetInfo();
        pet1.setPk(1);
        pet1.setFkAccount(1);
        pet1.setName("pname");
        pet1.setBirth(Date.valueOf("2017-11-11"));
        pet1.setFkPetBreed(1);
        pet1.setGender(1);
        pet1.setIsNeuter(1);

        breed1 = new Breed();
        breed1.setPk(1);
        breed1.setName("siba");

        userInfo = new UserInfo();
        userInfo.setFKaccount(1);
        userInfo.setName("kim");
        userInfo.setBirth(Date.valueOf("2017-11-11"));
        userInfo.setAddress("home");
        userInfo.setTel(010);
        userInfo.setCreateDate(Date.valueOf("2017-11-11"));
        userInfo.setNickName("kim");
        userInfo.setGender(1);

        location = new Location();
        location.setPlaceCode(1);
        location.setName("name");
        location.setAddress(1);
        location.setTime(1);
        location.setUserId(1);
        location.setImg(1);
        location.setLike(1);

        placeImg = new PlaceImg();
        placeImg.setSize(1);
        placeImg.setName("name");
        placeImg.setWriter("writer");
        placeImg.setPath(1);
        placeImg.setLocationCode(1);

        place = new Place();
        place.setPlaceName("name");
    }

    @Test
    public void create(){
        AccountDAO dao = new AccountDAO();

        Account account2 = dao.read("pk", "15").get(0);

        account2.setCount(3);

        dao.update(account2);

        System.out.println(dao.read("pk", "15").get(0).toString());

        /*dao.deleteAll();
        assertThat(dao.count(),is(0));

        dao.create(account1);
        assertThat(dao.count(),is(1));

        Account account2 = dao.read("pk", "1").get(0);

        assertThat(account2.getEmail(), is("apple"));

        System.out.println(account1.toString());

        assertThat(account1.getPassword(), is("aaa"));

        account1.setPassword("ddd");

        dao.update(account1);
        assertThat(dao.read("email", "apple").get(0).getPassword(), is("ddd"));


        dao.delete(account1);
        assertThat(dao.count(),is(0));*/

    }

    @Test
    public void petTest(){
        PetInfoDAO dao = new PetInfoDAO();

        /*dao.deleteAll();
        assertThat(dao.count(),is(0));*/

        /*dao.create(pet1);
        assertThat(dao.count(),is(1));*/
        PetInfo petInfo = dao.read("pk", "2").get(0);

        System.out.println(petInfo.toString());

        petInfo.setGender(0);

        dao.update(petInfo);

    }

    @Test
    public void breedTest(){
        BreedDAO dao = new BreedDAO();

        dao.deleteAll();
        assertThat(dao.count(),is(0));

        dao.create("cogi");
        assertThat(dao.count(),is(1));

        dao.update("siba", "cogi");
        System.out.println(dao.read("siba"));

        dao.delete("siba");
        assertThat(dao.count(),is(0));

    }

    @Test
    public void userinfoTest(){
        UserInfoDAO dao = new UserInfoDAO();

        /*dao.create(userInfo);*/

        UserInfo user = dao.read("name", "kim").get(0);

        user.setName("hong");

        dao.update(user);

        /*dao.delUser("name", "kim");

        dao.addUser(userInfo);

        dao.modUser("name","kim","name","tae");*/

        /*System.out.println(dao.getUser("name", "tae").get(0).getName());*/

    }

    @Test
    public void locationTest(){
        LocationDAO dao = new LocationDAO();

        /*dao.addLocation(location);

        dao.modLocation("name", "name", "name", "kwon");*/

        /*dao.delLocation("name", "kwon");*/

        /*dao.delLocation("name", "name");*/
        /*System.out.println(dao.getLocation("name", "name").get(0).getName());*/

    }

    @Test
    public void placeImgTest(){
        PlaceImgDAO dao = new PlaceImgDAO();

        /*dao.addPlaceImg(placeImg);*/

        /*dao.delPlaceImg("name", "name");*/

        /*dao.modPlaceImg("name", "name", "name", "kim");*/

        System.out.println(dao.getPlaceImg("name", "kim").get(0).getName());
    }

    @Test
    public void placeTest(){
        PlaceDAO dao = new PlaceDAO();
        /*dao.addPlace(place);*/

        /*dao.delPlace("place_name", "name");*/

        /*dao.modPlace("place_name", "name" ,"place_name", "kim");*/

        System.out.println(dao.getPlace("place_name", "kim").get(0).getPlaceName());
    }

    @Test
    public void SQTest(){
        SecurityQuestionDAO dao = new SecurityQuestionDAO();
        SecurityQuestion securityQuestion = new SecurityQuestion();

        securityQuestion.setPk(1);
        securityQuestion.setFkAccount(1);
        securityQuestion.setQuestion("aaaaa");
        securityQuestion.setAnswer("bbbbb");
        securityQuestion.setCnt(1);

        dao.create(securityQuestion);

        System.out.println(dao.read("pk", "1").get(0).getAnswer());

        dao.delete(securityQuestion);
    }
}
