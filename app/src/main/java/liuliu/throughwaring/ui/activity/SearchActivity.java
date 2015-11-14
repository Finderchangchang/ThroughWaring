package liuliu.throughwaring.ui.activity;

import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import net.tsz.afinal.annotation.view.CodeNote;

import liuliu.custom.control.toolbar.TToolbar;
import liuliu.throughwaring.R;
import liuliu.throughwaring.base.BaseActivity;

public class SearchActivity extends BaseActivity {
    public static SearchActivity mInstance;
    @CodeNote(id = R.id.main_ll_registration_police, click = "onClick")
    LinearLayout registration_police;
    @CodeNote(id = R.id.main_ll_personnel_type, click = "onClick")
    LinearLayout personnel_type;
    @CodeNote(id = R.id.main_ll_selection_unit, click = "onClick")
    LinearLayout selection_unit;
    @CodeNote(id = R.id.main_ll_name_search, click = "onClick")
    LinearLayout name_search;
    @CodeNote(id = R.id.main_drawer)
    DrawerLayout mDrawerLayout;
    @CodeNote(id = R.id.main_right_nav_view_toolbar)
    TToolbar main_toolbar;

    @Override
    public void initViews() {
        setContentView(R.layout.activity_search);
        mInstance = this;
    }

    @Override
    public void initEvents() {

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_ll_registration_police://登记民警
                setRightDraw("登记民警");
                break;
            case R.id.main_ll_personnel_type://人员类型
                setRightDraw("人员类型");
                break;
            case R.id.main_ll_selection_unit://选择单位
                setRightDraw("选择单位");
                break;
            case R.id.main_ll_name_search://精确查找
                setRightDraw("精确查找");
                break;
        }
    }

    public void setRightDraw(String name) {
        mDrawerLayout.openDrawer(Gravity.RIGHT);
        main_toolbar.setCenterTitle(name);
    }
}
