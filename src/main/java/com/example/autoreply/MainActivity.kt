import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. العثور على الـ RecyclerView في ملف الـ layout باستخدام الـ ID الخاص به
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewReplies)

        // 2. إنشاء قائمة بيانات وهمية مؤقتة للاختبار
        val replyList = listOf(
            Reply("مستخدم واتساب 1", "10:45 م"),
            Reply("أحمد", "10:42 م"),
            Reply("فريق العمل", "9:15 م"),
            Reply("محمد", "8:30 م"),
            Reply("+1-202-555-0125", "7:00 م"),
            Reply("الوالدة", "6:55 م"),
            Reply("شركة الإنترنت", "4:10 م")
        )

        // 3. إنشاء نسخة من الـ Adapter الذي صنعناه وتمرير قائمة البيانات له
        val adapter = ReplyAdapter(replyList)

        // 4. هذه هي الخطوة الأهم: ربط الـ Adapter مع الـ RecyclerView
        recyclerView.adapter = adapter
    }
}
