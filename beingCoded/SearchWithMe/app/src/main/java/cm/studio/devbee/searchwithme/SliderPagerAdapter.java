package cm.studio.devbee.searchwithme;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {
    private Context mcontext;
    private List<Slider> sliderList;


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sliderLayout =inflater.inflate(R.layout.slider_item,null);
        ImageView sliderImage =sliderLayout.findViewById(R.id.image_slider);
        TextView sliderText=sliderLayout.findViewById(R.id.slider_title);
        sliderImage.setImageResource(sliderList.get(position).getImage());
        sliderText.setText(sliderList.get(position).getTitle());
        container.addView(sliderLayout);
        return sliderLayout;
    }


    public SliderPagerAdapter(Context mcontext, List<Slider> sliderList) {
        this.mcontext = mcontext;
        this.sliderList = sliderList;
    }

    @Override
    public int getCount() {
        return sliderList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
