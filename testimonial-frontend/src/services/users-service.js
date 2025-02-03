import { myAxios } from "./helper";

export const signUp=(user)=> {
    return myAxios
    .post("/users/addUser", user)
    .then((response) => response.data);
}