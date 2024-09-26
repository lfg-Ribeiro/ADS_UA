import { Library, User } from "./classes.js";
import {
  getUserData,
  getItemInfo,
  getLendInfo,
  getReturnCode,
  getSearchCode,
} from "./functions.js";

var lib = new Library();

document.getElementById("listCollectionBtn").addEventListener("click", () => {
  lib.listCollection();
});

document.getElementById("addUserBtn").addEventListener("click", () => {
  const user = getUserData();
  lib.addUser(user);

  console.log(lib.users);
});

document.getElementById("addItemBtn").addEventListener("click", () => {
  const entity = getItemInfo();
  lib.addItem(entity);

  console.log(lib.collection);
});

document.getElementById("lendItemBtn").addEventListener("click", () => {
  const entity = getLendInfo();
  lib.lendItem(entity.code, entity.registry);
});

document.getElementById("returnItemBtn").addEventListener("click", () => {
  const code = getReturnCode();
  lib.returnItem(code);
});

document.getElementById("infoBtn").addEventListener("click", () => {
  const code = getSearchCode();
  const foundItem = lib.collection.find((item) => item.code === code);

  if (foundItem) {
    foundItem.info();
  }
});

const user1 = new User('Luan Ribeiro', '505328', '2004-07-08');
lib.addUser(user1);

const user2 = new User('Luiza Silva', '505429', '2001-07-03');
lib.addUser(user2);

const user3 = new User('Henrique Sapeca', '000420', '2002-10-31');
lib.addUser(user3);

const user4 = new User('Lionel Messi', '000010', '1987-06-24');
lib.addUser(user4);

const user5 = new User('Felipe Vidal', '505272', '2004-08-08');
lib.addUser(user5);

console.log(lib.users);