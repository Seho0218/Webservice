//사용자 정의 모듈 만들기
//모듈을 생성하기 위해서는exports라는 내장객체를 이용하여 변수 또는 함수를 정의한다.

//1. 변수 선언하는 방법
exports.num =123;
exports.name="홍길동";

//2.함수를 모듈로 선언하는 방법
/**function hap(n1,n2){
 * return n1+n2;
 * }
 */

exports.hap=function(n1,n2){
    return n1+n2;
}
// 임의의 값까지 합 구하기
exports.sum=function(max){
    var s=0;
    for(var i=1;i<=max; i++){
        s+=i;
    }
    return s;
}

//단을 입력하여 해당하는 구구단을 구하는 함수
exports.gugudan=(dan)=>{
    var result="";
    for(var i=2;i<=9;i++){
        result += dan+"*"+i+"="+(dan*i)+"<br/>";
    }
    return result;
}