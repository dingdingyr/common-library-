package wehax.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class ExpandableGridView extends GridView {

	private boolean canExtend = false;

	public ExpandableGridView(Context context) {
		super(context);

	}

	public ExpandableGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (!canExtend) {
			int expandSpec = MeasureSpec.makeMeasureSpec(
					Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
			super.onMeasure(widthMeasureSpec, expandSpec);
		} else {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}

	}

	/**
	 * 设置是否能伸缩,默认为false,不可伸缩滚动，高度固定
	 * 
	 * @param canExtend
	 *            true:可伸缩，普通的listview,false:不可伸缩，高度固定
	 */
	public void setExtendable(boolean canExtend) {
		this.canExtend = canExtend;
	}
}
