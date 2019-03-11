
package ru.trandefil.sc.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.trandefil.sc.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteUserByName_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "deleteUserByName");
    private final static QName _DeleteUserByNameResponse_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "deleteUserByNameResponse");
    private final static QName _GetAllUsers_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "getAllUsers");
    private final static QName _GetAllUsersResponse_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "getAllUsersResponse");
    private final static QName _GetLoggedUser_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "getLoggedUser");
    private final static QName _GetLoggedUserResponse_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "getLoggedUserResponse");
    private final static QName _GetUserByName_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "getUserByName");
    private final static QName _GetUserByNameResponse_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "getUserByNameResponse");
    private final static QName _SaveUser_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "saveUser");
    private final static QName _SaveUserResponse_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "saveUserResponse");
    private final static QName _UpdateUser_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "updateUser");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://endpoint.sc.trandefil.ru/", "updateUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.trandefil.sc.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteUserByName }
     * 
     */
    public DeleteUserByName createDeleteUserByName() {
        return new DeleteUserByName();
    }

    /**
     * Create an instance of {@link DeleteUserByNameResponse }
     * 
     */
    public DeleteUserByNameResponse createDeleteUserByNameResponse() {
        return new DeleteUserByNameResponse();
    }

    /**
     * Create an instance of {@link GetAllUsers }
     * 
     */
    public GetAllUsers createGetAllUsers() {
        return new GetAllUsers();
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
    }

    /**
     * Create an instance of {@link GetLoggedUser }
     * 
     */
    public GetLoggedUser createGetLoggedUser() {
        return new GetLoggedUser();
    }

    /**
     * Create an instance of {@link GetLoggedUserResponse }
     * 
     */
    public GetLoggedUserResponse createGetLoggedUserResponse() {
        return new GetLoggedUserResponse();
    }

    /**
     * Create an instance of {@link GetUserByName }
     * 
     */
    public GetUserByName createGetUserByName() {
        return new GetUserByName();
    }

    /**
     * Create an instance of {@link GetUserByNameResponse }
     * 
     */
    public GetUserByNameResponse createGetUserByNameResponse() {
        return new GetUserByNameResponse();
    }

    /**
     * Create an instance of {@link SaveUser }
     * 
     */
    public SaveUser createSaveUser() {
        return new SaveUser();
    }

    /**
     * Create an instance of {@link SaveUserResponse }
     * 
     */
    public SaveUserResponse createSaveUserResponse() {
        return new SaveUserResponse();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "deleteUserByName")
    public JAXBElement<DeleteUserByName> createDeleteUserByName(DeleteUserByName value) {
        return new JAXBElement<DeleteUserByName>(_DeleteUserByName_QNAME, DeleteUserByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "deleteUserByNameResponse")
    public JAXBElement<DeleteUserByNameResponse> createDeleteUserByNameResponse(DeleteUserByNameResponse value) {
        return new JAXBElement<DeleteUserByNameResponse>(_DeleteUserByNameResponse_QNAME, DeleteUserByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "getAllUsers")
    public JAXBElement<GetAllUsers> createGetAllUsers(GetAllUsers value) {
        return new JAXBElement<GetAllUsers>(_GetAllUsers_QNAME, GetAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "getAllUsersResponse")
    public JAXBElement<GetAllUsersResponse> createGetAllUsersResponse(GetAllUsersResponse value) {
        return new JAXBElement<GetAllUsersResponse>(_GetAllUsersResponse_QNAME, GetAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoggedUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "getLoggedUser")
    public JAXBElement<GetLoggedUser> createGetLoggedUser(GetLoggedUser value) {
        return new JAXBElement<GetLoggedUser>(_GetLoggedUser_QNAME, GetLoggedUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLoggedUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "getLoggedUserResponse")
    public JAXBElement<GetLoggedUserResponse> createGetLoggedUserResponse(GetLoggedUserResponse value) {
        return new JAXBElement<GetLoggedUserResponse>(_GetLoggedUserResponse_QNAME, GetLoggedUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "getUserByName")
    public JAXBElement<GetUserByName> createGetUserByName(GetUserByName value) {
        return new JAXBElement<GetUserByName>(_GetUserByName_QNAME, GetUserByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "getUserByNameResponse")
    public JAXBElement<GetUserByNameResponse> createGetUserByNameResponse(GetUserByNameResponse value) {
        return new JAXBElement<GetUserByNameResponse>(_GetUserByNameResponse_QNAME, GetUserByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "saveUser")
    public JAXBElement<SaveUser> createSaveUser(SaveUser value) {
        return new JAXBElement<SaveUser>(_SaveUser_QNAME, SaveUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "saveUserResponse")
    public JAXBElement<SaveUserResponse> createSaveUserResponse(SaveUserResponse value) {
        return new JAXBElement<SaveUserResponse>(_SaveUserResponse_QNAME, SaveUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.sc.trandefil.ru/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

}
