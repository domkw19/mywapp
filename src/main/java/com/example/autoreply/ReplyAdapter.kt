import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 1. كلاس بسيط لتمثيل البيانات (هذا سيمثل لاحقاً جدوال Room)
data class Reply(
    val senderName: String,
    val replyTime: String
)

// 2. هذا هو الـ Adapter
class ReplyAdapter(private val replies: List<Reply>) : RecyclerView.Adapter<ReplyAdapter.ReplyViewHolder>() {

    /**
     * هذا الكلاس الداخلي يمثل الواجهة لصف واحد فقط.
     * وظيفته هي الاحتفاظ بالعناصر الداخلية في الـ layout (TextViews) لسهولة الوصول إليها.
     */
    inner class ReplyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderNameTextView: TextView = itemView.findViewById(R.id.textViewSenderName)
        val replyTimeTextView: TextView = itemView.findViewById(R.id.textViewReplyTime)
    }

    /**
     * هذه الدالة تُستدعى عندما يقوم الـ RecyclerView بإنشاء صف جديد.
     * مهمتها هي تجهيز ملف الـ XML الخاص بالصف (reply_log_item.xml).
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReplyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reply_log_item, parent, false)
        return ReplyViewHolder(view)
    }

    /**
     * هذه الدالة تُستدعى لتعبئة البيانات في صف معين.
     * تأخذ البيانات من القائمة (replies) وتضعها في واجهة الصف (ViewHolder).
     */
    override fun onBindViewHolder(holder: ReplyViewHolder, position: Int) {
        val currentReply = replies[position]
        holder.senderNameTextView.text = currentReply.senderName
        holder.replyTimeTextView.text = currentReply.replyTime
    }

    /**
     * هذه الدالة تخبر الـ RecyclerView عن العدد الإجمالي للعناصر في القائمة.
     */
    override fun getItemCount(): Int {
        return replies.size
    }
}
