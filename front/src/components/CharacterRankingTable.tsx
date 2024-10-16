import React, { useState, useEffect, CSSProperties } from "react";

interface CustomCSSProperties extends CSSProperties {
  "--target-width"?: string;
}

interface RankingItem {
  name: string;
  icon: string;
  value: number;
}

interface CharacterRankingTableProps {
  fnc: () => Promise<RankingItem[]>;
}

const CharacterRankingTable: React.FC<CharacterRankingTableProps> = ({ fnc }) => {
  const [animate, setAnimate] = useState(false);
  const [data, setData] = useState<RankingItem[]>([]);
  const [loading, setLoading] = useState(true); // 로딩 상태 추가

  useEffect(() => {
    setAnimate(true);
  }, []);

  useEffect(() => {
    fnc()
      .then((resData) => {
        if (resData && resData.length > 0) {
          setData(resData);
        }
      })
      .finally(() => setLoading(false));
  }, [fnc]);

  if (loading) {
    return <div>Loading...</div>; // 로딩 중일 때 표시할 메시지
  }

  // MAXVALUE가 0일 경우 NaN 방지
  const MAXVALUE = data.length > 0 ? Math.max(...data.map((item) => item.value), 0) : 1;

  return (
    <div className="w-full max-w-2xl mx-auto bg-gray-900 text-white p-4">
      <h2 className="text-xl font-bold mb-4">Lost Ark 직업 분포도</h2>
      <div className="space-y-2">
        {data.map((item, index) => {
          const percentage = MAXVALUE === 0 ? 0 : (item.value / MAXVALUE) * 100; // NaN 방지를 위해 0 체크
          return (
            <div key={index} className="flex items-center">
              <span className="w-6 text-center mr-2">
                <img src={item.icon} alt="classIcon" />
              </span>
              <span className="w-24 mr-2">{item.name}</span>
              <div className="flex-grow bg-gray-700 h-5 rounded-full overflow-hidden">
                <div
                  className={`h-full bg-gradient-to-r from-gray-500 to-gray-600 transition-all duration-1000 ease-out ${
                    animate ? "animate-custom-width" : ""
                  }`}
                  style={
                    {
                      "--target-width": `${percentage}%`,
                      width: animate ? "var(--target-width)" : "0%",
                    } as CustomCSSProperties
                  }
                ></div>
              </div>
              <span className="ml-2 w-12 text-right">
                {isNaN(percentage) ? "0.00%" : percentage.toFixed(2)}% {/* NaN 방지 */}
              </span>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default CharacterRankingTable;