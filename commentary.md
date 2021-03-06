# commentary for チームNeiro
## チーム運営について
早くからペアプログラミングを行っていたため、進捗は安定していたと思います。  
ペアプログラミングから学ぶことが多かったと思いますので、今回の進め方としては適していました。  
また、タスク管理にGithub projectを利用してみていたのもよい挑戦でした。  
業務で実際に利用しているプロジェクトも多いので、使い方や機能を知っておくと今後役に立つことも多いと思います。  

## 実装内容について
追加機能が多く、作成できたコードは非常に多かったです。  
コードレビュー時にお話ししたTeamクラスも追加されており、新しいアイデアを積極的に取り込めています。  
一方、戦闘から逃げるとプログラムが終了してしまう動作になっているなど、  
全体の動作設計やゲームとしての挙動を作りこむ部分はもう一歩といったところでした。  
ペアで新しい機能を作っていくことに時間を割いたためと思いますが、  
全体で中間レビュー・動作確認をする時間を取って、タスクの再設定や優先順位確認をしておくとよかったかもしれません。  

### パッケージ分割について
rpgパッケージ内に、MainクラスとMosterクラスがまとめて入っています。  
Monsterクラスの派生クラスが、キャラクターの数を増やすにつれて増加していく構造になっているので、Monster パッケージを作ってもよかったように思います。  

### mainの肥大化と分散について
多くの機能を実装していくうち、処理の入り口になるクラスは肥大化していきがちです。  
ここまで講義で扱ってきた範囲の知識では、回避しづらい問題です。  
これを避けるための方法として、クラス分割やDI（依存性注入）が活用できます。  
業務で扱うアプリケーションでも必要になりますので、次のステップとしてこれを理解できるようにしていくとよいです。  
これらの対策を行えるようになることは、プログラミングの理解度の一つの節目になると思います。引き続き頑張ってください。  
