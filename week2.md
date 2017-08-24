# Data Structure-week 2

### 알고리즘 분석 - 시간복잡도, 공간복잡도
시간복잡도 : 최악의 경우가 가장 중요

#### 알고리즘의 성능 측정
1) 실제로 해본다  
프로그램 작성 후, `System.currentTimeMillis()` 등을 사용하여 실제 걸리는 시간을 실제로 측정(c/c++ 에서는 `clock()`) 후 기록  

**실측정의 한계**  
Machine-dependent.  
완벽한 알고리즘을 설계해야한다.

2) 이론적 성능 측정  
의사코드에서 가장 중요한 operation(`primitive operation`) 을 선택한 다음, input이 n이라 가정하고 함수식으로 표현

### Primitive Operations  
가능하면 일정한 시간이 걸리는 연산  
의사코드에 명확하게 드러나고, 언어가 무엇이든 딱히 상관없는(?) 프로시저  
제일 흔한건 `if` statement. ex)sorting, searching

but, 모든 가능한 operation들을 다 카운팅할 필요가 있는가? -> Asymptotic Algorithm Analysis

### Asymptotic Algorithm Analysis  
big-o, big-omega, big-theta  

big-o : 최악의 경우에 알고리즘의 실행시간을 측정하는 방법. 인풋 개수가 무한대로 뻗을 때를 보는 것이기 때문에, 최고차항만 남겨둔다.  
ex) T(n) = 2n^2+4n+4, O(n) = n^2  

big-omega : 최선의 경우에 알고리즘의 실행시간을 측정.  
big-theta : big-o, big-omega 둘 다 만족하는 경우  
(가장 중요한 것은 `big-o` 이다)
