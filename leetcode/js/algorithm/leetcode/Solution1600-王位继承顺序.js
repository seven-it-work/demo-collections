var autoIndex = 0;

var KingOjb = function (kingName, age) {
    KingOjb.prototype.name = kingName;
    KingOjb.prototype.age = age;
    KingOjb.prototype.isDead = false;
    KingOjb.prototype.children = new Map();

}
KingOjb.prototype.birth = function (name) {
    let kingOjb = new KingOjb(name, autoIndex++);
    this.children.set(kingOjb.name, kingOjb);
    return kingOjb;
}
KingOjb.prototype.death = function () {
    this.isDead = true;
}
KingOjb.prototype.getByName = function (name) {
    return this.children.get(name);
}

/**
 * @param {string} kingName
 */
var ThroneInheritance = function (kingName) {
    ThroneInheritance.prototype.father = new KingOjb(kingName, autoIndex++);
    ThroneInheritance.prototype.kingMap = new Map();
    this.kingMap.set(kingName, this.father);
};

/**
 * @param {string} parentName
 * @param {string} childName
 * @return {void}
 */
ThroneInheritance.prototype.birth = function (parentName, childName) {
    let parent = this.kingMap.get(parentName);
    if (parent && !parent.isDead) {
        const birth = parent.birth(childName);
        this.kingMap.set(childName, birth);
    }
};

/**
 * @param {string} name
 * @return {void}
 */
ThroneInheritance.prototype.death = function (name) {
    let king = this.kingMap.get(name);
    if (king) {
        king.death();
        this.kingMap.delete(name);
    }
};

/**
 * @return {string[]}
 */
ThroneInheritance.prototype.getInheritanceOrder = function () {
    let list = [];
    if (!this.father.isDead) {
    } else {
        list.push(this.father);
    }
    list = formatList(this.father.children);
    return list.sort((kingOjb1, kingOjb2) => kingOjb1.age - kingOjb2.age).map(kingObj => kingObj.name);
};

function formatList(kingObjMap) {
    let list = [];
    if (kingObjMap){
        kingObjMap.forEach((kingObj) => {
            if (!kingObj.isDead) {
                list.push(kingObj);
                list.push(formatList(kingObj.children));
            }
        })
    }
    return list;
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * var obj = new ThroneInheritance(kingName)
 * obj.birth(parentName,childName)
 * obj.death(name)
 * var param_3 = obj.getInheritanceOrder()
 */

var throneInheritance = new ThroneInheritance("king");
throneInheritance.birth("king", "andy");
throneInheritance.birth("king", "bob");
throneInheritance.birth("king", "catherine");
throneInheritance.birth("andy", "matthew");
throneInheritance.birth("bob", "alex");
throneInheritance.birth("bob", "asha");
console.log(throneInheritance.getInheritanceOrder());
throneInheritance.death("bob");
console.log(throneInheritance.getInheritanceOrder());
